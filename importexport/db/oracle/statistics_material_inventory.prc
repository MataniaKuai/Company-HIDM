create or replace procedure statistics_material_inventory(histmon varchar2)
 as     
    cursor cur_material is 
     select material_no,goods_code,hs_code,tax_preperty,free_no,iterm,unit,goods_desc,chinese_name
      from T_MATERIAL;
      
    cur_material_record cur_material%ROWTYPE; 
          
    tmp_count number:=0; 
    tmp_id number:=0;
    tmp_date date;
    tmp_begin_qty number(13,3);
    tmp_begin_count number:=0;      
    
    tmp_vendor T_IMPORT_ITEM.Vendor%TYPE;
    tmp_dept T_IMPORT_ITEM.Dept%TYPE;
    tmp_employee_no T_IMPORT_ITEM.Employee_No%TYPE;
    
    x_gr_qty t_material_inventory.gr_qty%TYPE; --收货数量
    x101_qty t_material_inventory.gr_qty%TYPE;
    x102_qty t_material_inventory.gr_qty%TYPE;
        
    x_retreat_goods_qty t_material_inventory.retreat_goods_qty%TYPE; --退货数量
    x_re122_qty t_material_inventory.retreat_goods_qty%TYPE;
    x_re123_qty t_material_inventory.retreat_goods_qty%TYPE;
    
    x_use_goods_qty  t_material_inventory.use_goods_qty%TYPE; --领用数量
    x_use201_qty t_material_inventory.use_goods_qty%TYPE;
    x_use202_qty t_material_inventory.use_goods_qty%TYPE;
    
    x_return_material_qty t_material_inventory.return_material_qty%TYPE; -- 退料数量
    x_return202_qty t_material_inventory.return_material_qty%TYPE;
    x_return201_qty t_material_inventory.return_material_qty%TYPE;
    
    x_production_scrap_qty t_material_inventory.production_scrap_qty%TYPE; --生产报废
    x_inline_goods_qty t_material_inventory.inline_goods_qty%TYPE; --在线数量
    
    x_inventory_scrap_qty t_material_inventory.inventory_scrap_qty%TYPE; --库存报废数量
    x_inv_z07_qty t_material_inventory.inventory_scrap_qty%TYPE;
    x_inv_z08_qty t_material_inventory.inventory_scrap_qty%TYPE;
    
    x_resale_qty t_material_inventory.resale_qty%TYPE; --转售数量
    
    x_inventory_profit_qty t_material_inventory.inventory_profit_qty%TYPE; --盘盈数量
    x_profit_z03_qty t_material_inventory.inventory_profit_qty%TYPE;
    x_profit_z04_qty t_material_inventory.inventory_profit_qty%TYPE;
    
    x_inventory_losses_qty t_material_inventory.inventory_losses_qty%TYPE; --盘亏数量
    x_losses_z05_qty t_material_inventory.inventory_losses_qty%TYPE;
    x_losses_z06_qty t_material_inventory.inventory_losses_qty%TYPE;    
    
    x_scrap_inventory_qty t_material_inventory.scrap_inventory_qty%TYPE; --报废库存
    x_scrap_z09_qty t_material_inventory.scrap_inventory_qty%TYPE;
    x_scrap_z10_qty t_material_inventory.scrap_inventory_qty%TYPE;
    
    x_destroy_qty t_material_inventory.destroy_qty%TYPE; --销毁数量   
    
    tmp_sql varchar2(5000):=''; 
    
begin
  
    execute immediate 'delete from t_material_inventory x where x.histmon='''||histmon||'''';
    commit;  

    OPEN cur_material;   
    LOOP   
       FETCH cur_material INTO cur_material_record;   
       EXIT WHEN cur_material%NOTFOUND;         
       -----插入一条月的物料数据
       insert into t_material_inventory(id,histmon,goods_code,goods_description,goods_description_cn,hs_code,tax_preperty,
                          free_no,iterm,unit,material_no
                    )values(
                         t_material_seq.nextval,histmon,cur_material_record.goods_code,cur_material_record.goods_desc,
                         cur_material_record.chinese_name,cur_material_record.hs_code,
                         cur_material_record.tax_preperty,cur_material_record.free_no,cur_material_record.iterm,
                         cur_material_record.unit,cur_material_record.material_no
                    );
       commit;  
       
       select count(1) into tmp_count from T_IMPORT_ITEM where material_no=cur_material_record.material_no;
       
        if tmp_count>0 then
           
           select max(id) into tmp_id from T_IMPORT_ITEM where material_no=cur_material_record.material_no;
                               
           select vendor,dept,employee_no into tmp_vendor,tmp_dept,tmp_employee_no
             from T_IMPORT_ITEM 
            where material_no=cur_material_record.material_no and id= tmp_id;
            
           UPDATE t_material_inventory a 
              SET vendor=tmp_vendor,dept=tmp_dept,user_id=tmp_employee_no 
            where a.material_no=cur_material_record.material_no and a.histmon=histmon;
                       
           commit;
        end if;       
           -------更新统计的数据
           
           ---收货数量
           select nvl(sum(nvl(qty,0)),0) into x101_qty 
             from  t_gr_re_movement_data
             where post_date like histmon||'%'
               and movement_type='101'
               and material_code = cur_material_record.material_no;
           
           select nvl(sum(nvl(qty,0)),0) into x102_qty 
            from  t_gr_re_movement_data
           where post_date like histmon||'%'
             and movement_type='102'
             and material_code = cur_material_record.material_no;                
           x_gr_qty := x101_qty-x102_qty;
           
           ---退货数量
           select nvl(sum(nvl(qty,0)),0) into x_re122_qty 
             from  t_gr_re_movement_data
             where post_date like histmon||'%'
               and movement_type='122'
               and material_code = cur_material_record.material_no;  
           
           select nvl(sum(nvl(qty,0)),0) into x_re123_qty 
             from  t_gr_re_movement_data
             where post_date like histmon||'%'
               and movement_type='123'
               and material_code = cur_material_record.material_no;             
               
           x_retreat_goods_qty := x_re122_qty - x_re123_qty;
           ---领用数量
           select nvl(sum(nvl(qty,0)),0) into x_use201_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('1000','100N')
              and movement_type='201'
              and material_code = cur_material_record.material_no; 
              
           ---   
          select nvl(sum(nvl(b.qty,0)),0) into x_use202_qty
            from  
          (select CERTIFICATE_YEAR,CERTIFICATE_ITEM,MATERIAL_CODE,
                 FACTORY,INVENTORY_LOCATION,MOVEMENT_TYPE,BATCH_NUMBER,QTY,
                 POST_DATE,CERTIFICATE_NO,CERTIFICATE_NO_S,CERTIFICATE_ITEM_S
            from t_movement_data
           where post_date like histmon||'%'
             and factory in ('1000','100N')
             and movement_type='201'
             and material_code = cur_material_record.material_no
           ) a,
          (select CERTIFICATE_YEAR,CERTIFICATE_ITEM,MATERIAL_CODE,
                 FACTORY,INVENTORY_LOCATION,MOVEMENT_TYPE,BATCH_NUMBER,QTY,
                 POST_DATE,CERTIFICATE_NO,CERTIFICATE_NO_S,CERTIFICATE_ITEM_S
            from t_movement_data
           where post_date like histmon||'%'
             and factory in ('1000','100N')
             and movement_type='202'
             and material_code = cur_material_record.material_no
           ) b
           where a.CERTIFICATE_NO=b.CERTIFICATE_NO_S
             and a.CERTIFICATE_ITEM =b.CERTIFICATE_ITEM_S;             
              
           x_use_goods_qty :=  x_use201_qty-x_use202_qty;
           ---退料数量
           select nvl(sum(nvl(qty,0)),0) into x_return202_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('1000','100N')
              and movement_type='202'
              and material_code = cur_material_record.material_no; 
              
          select nvl(sum(nvl(b.qty,0)),0) into x_return201_qty
            from  
          (select CERTIFICATE_YEAR,CERTIFICATE_ITEM,MATERIAL_CODE,
                 FACTORY,INVENTORY_LOCATION,MOVEMENT_TYPE,BATCH_NUMBER,QTY,
                 POST_DATE,CERTIFICATE_NO,CERTIFICATE_NO_S,CERTIFICATE_ITEM_S
            from t_movement_data
           where post_date like histmon||'%'
             and factory in ('1000','100N')
             and movement_type='202'
             and material_code = cur_material_record.material_no
           ) a,
          (select CERTIFICATE_YEAR,CERTIFICATE_ITEM,MATERIAL_CODE,
                 FACTORY,INVENTORY_LOCATION,MOVEMENT_TYPE,BATCH_NUMBER,QTY,
                 POST_DATE,CERTIFICATE_NO,CERTIFICATE_NO_S,CERTIFICATE_ITEM_S
            from t_movement_data
           where post_date like histmon||'%'
             and factory in ('1000','100N')
             and movement_type='201'
             and material_code = cur_material_record.material_no
           ) b
           where a.CERTIFICATE_NO=b.CERTIFICATE_NO_S
             and a.CERTIFICATE_ITEM =b.CERTIFICATE_ITEM_S;               
                                
           x_return_material_qty := x_return202_qty-x_return201_qty;
           
           ---库存报废数量
           select nvl(sum(nvl(qty,0)),0) into x_inv_z07_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('1000')
              and movement_type='Z07'
              and material_code = cur_material_record.material_no;   
                       
           select nvl(sum(nvl(qty,0)),0) into x_inv_z08_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('1000')
              and movement_type='Z08'
              and material_code = cur_material_record.material_no; 
              
           x_inventory_scrap_qty := x_inv_z07_qty- x_inv_z08_qty;                   
              
           ---转售数量          
           x_resale_qty := 0;
           
           ---盘盈数量
           --x_profit_z03_qty
            select nvl(sum(nvl(qty,0)),0) into x_profit_z03_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('1000','100N','100S')
              and movement_type='Z03'
              and material_code = cur_material_record.material_no; 

           select nvl(sum(nvl(qty,0)),0) into x_profit_z04_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('1000','100N','100S')
              and movement_type='Z04'
              and material_code = cur_material_record.material_no;           
           x_inventory_profit_qty := x_profit_z03_qty - x_profit_z04_qty;
           
           ---盘亏数量
           --x_losses_z05_qty
           select nvl(sum(nvl(qty,0)),0) into x_losses_z05_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('1000','100N','100S')
              and movement_type='Z05'
              and material_code = cur_material_record.material_no;
           
           select nvl(sum(nvl(qty,0)),0) into x_losses_z06_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('1000','100N','100S')
              and movement_type='Z06'
              and material_code = cur_material_record.material_no;
           x_inventory_losses_qty := x_losses_z05_qty - x_losses_z06_qty;
           
           ---报废库存
           --x_scrap_z09_qty
            select nvl(sum(nvl(qty,0)),0) into x_scrap_z09_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('100N')
              and movement_type='Z09'
              and material_code = cur_material_record.material_no;
           
           select nvl(sum(nvl(qty,0)),0) into x_scrap_z10_qty
             from t_movement_data
            where post_date like histmon||'%'
              and factory in ('100N')
              and movement_type='Z10'
              and material_code = cur_material_record.material_no;          
           x_scrap_inventory_qty :=  x_scrap_z09_qty - x_scrap_z10_qty;
           
           ---销毁数量
           x_destroy_qty := 0;
                      
           ---生产报废
           x_production_scrap_qty := x_scrap_inventory_qty - x_inventory_scrap_qty;
                       
           ---在线数量
           if histmon='201808' then
             x_inline_goods_qty := 0+x_use_goods_qty-x_return_material_qty-x_production_scrap_qty;             
           else
              tmp_date := TO_DATE(histmon||'01','yyyyMMdd')-1;              
              select count(1) into tmp_begin_count from t_material_inventory a 
               where a.histmon= to_char(tmp_date,'yyyyMMdd')
                 and a.material_no=cur_material_record.material_no;
              tmp_begin_qty:=0;
              if tmp_begin_count>0 then
                 select inline_goods_qty into tmp_begin_qty  
                   from t_material_inventory a 
                  where a.histmon= tmp_date 
                    and a.material_no=cur_material_record.material_no;                
              end if;                             
              x_inline_goods_qty:= tmp_begin_qty+x_use_goods_qty-x_return_material_qty-x_production_scrap_qty;                         
           end if;
           
         tmp_sql:=  '
             update t_material_inventory a
                set gr_qty= '|| x_gr_qty||' ,
                 retreat_goods_qty= '|| x_retreat_goods_qty ||',
                 use_goods_qty= '||x_use_goods_qty ||',
                 return_material_qty= '||x_return_material_qty||',
                 production_scrap_qty= '||x_production_scrap_qty||',
                 inline_goods_qty= '||x_inline_goods_qty||',
                 inventory_scrap_qty= '||x_inventory_scrap_qty||',
                 resale_qty= '||x_resale_qty||',
                 inventory_profit_qty= '||x_inventory_profit_qty||',
                 inventory_losses_qty= '||x_inventory_losses_qty||',
                 scrap_inventory_qty= '||x_scrap_inventory_qty||',
                 destroy_qty='|| x_destroy_qty ||',
                 insert_time= sysdate       
           where a.histmon = '''||histmon||'''
             and a.material_no = '''||cur_material_record.material_no||'''';
           
         execute immediate tmp_sql; 
             
           commit;
           
             
 
       --DBMS_OUTPUT.PUT_LINE('');   
    END LOOP;  
  
  
exception  
     when too_many_rows then  
     DBMS_OUTPUT.PUT_LINE('返回值多于1行');  
     when others then  
     DBMS_OUTPUT.PUT_LINE('在RUNBYPARMETERS过程中出错！');    
end;
/
