package com.hidm.importexport.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.importexport.dao.ChartsDao;
import com.hidm.importexport.entity.ChartsResult;
import com.hidm.importexport.entity.Material;
import com.hidm.importexport.service.ChartsService;
import com.hidm.importexport.service.SAPConn;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

@Service(value = "chartsService")
public class ChartsServiceImpl implements ChartsService {
    private static final Logger log = LoggerFactory.getLogger(ChartsServiceImpl.class);
    @Autowired  
    private ChartsDao chartsDao;
    
    @Autowired
    private SAPConn sapConService;
    
    @Value("${hisdata_days}")
    private String hisDataDays;

    public List<ChartsResult> countMaterial() {
        return chartsDao.countMaterial();
    }

    @Transactional
    public void delMaterialHis() {
        chartsDao.delMaterialHis(Integer.parseInt(hisDataDays)+1);
    }

    @Transactional
    public void delMaterial() {
        chartsDao.delMaterial();
    }
    
    //同步SAP数据
    @Transactional
    public int sync() {
        int rows = 0;
        JCoFunction function = null;
        JCoDestination destination = sapConService.connect();
        JCoTable table = null;
        log.info("===========start call to ZSIMM_001=============== ");
        try {
            function = destination.getRepository().getFunction("ZSIMM_001");
            
            function.execute(destination);
            table = function.getTableParameterList().getTable("T_DATA");
            //连接SAP接口成功后 打印table信息
            log.info("Success to call SAP to sync PO info. " + table.toXML());

            rows = table.getNumRows();
            log.info("table rows:" + rows);
            
            List<Material> materials = new ArrayList<Material>();
            
            table.firstRow();
            for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) 
            {
                Material material = new Material();
                String matnr = table.getString("MATNR");
                String bismt = table.getString("BISMT");
                String maktx = table.getString("MAKTX");
                String mtart = table.getString("MTART");
                String mtbez = table.getString("MTBEZ");
                String meins = table.getString("MEINS");
                String matkl = table.getString("MATKL");
                String wgbez = table.getString("WGBEZ");
                String spart = table.getString("SPART");
                String bstme = table.getString("BSTME");
                String ersda = table.getString("ERSDA");
                String lvorm = table.getString("LVORM");
                String ernam = table.getString("ERNAM");
                String laeda = table.getString("LAEDA");
                String aenam = table.getString("AENAM");
                String mhdrz = table.getString("MHDRZ");
                String mhdhb = table.getString("MHDHB");
                String iprkz = table.getString("IPRKZ");
                String werks = table.getString("WERKS");
                String mtvfp = table.getString("MTVFP");
                String ekgrp = table.getString("EKGRP");
                String xchpf = table.getString("XCHPF");
                String dismm = table.getString("DISMM");
                String dispo = table.getString("DISPO");
                String disls = table.getString("DISLS");
                String bstmi = table.getString("BSTMI");
                String bstrf = table.getString("BSTRF");
                String beskz = table.getString("BESKZ");
                String sobsl = table.getString("SOBSL");
                String rgekz = table.getString("RGEKZ");
                String lgpro = table.getString("LGPRO");
                String lgfsb = table.getString("LGFSB");
                String dzeit = table.getString("DZEIT");
                String plifz = table.getString("PLIFZ");
                String fhori = table.getString("FHORI");
                String eisbe = table.getString("EISBE");
                String strgr = table.getString("STRGR");
                String sbdkz = table.getString("SBDKZ");
                String fevor = table.getString("FEVOR");
                String ncost = table.getString("NCOST");
                String mmsta = table.getString("MMSTA");
                String vint1 = table.getString("VINT1");
                String vint2 = table.getString("VINT2");
                String ueeto = table.getString("UEETO");
                String insmk = table.getString("INSMK");
                String lvorm1 = table.getString("LVORM1");
                String bklas = table.getString("BKLAS");
                String vprsv = table.getString("VPRSV");
                String peinh = table.getString("PEINH");
                String ekalr = table.getString("EKALR");
                String hkmat = table.getString("HKMAT");
                String mlast = table.getString("MLAST");
                String kosgr = table.getString("KOSGR");
                String ktgrm = table.getString("KTGRM");
                String mtpos = table.getString("MTPOS");
                String vkorg = table.getString("VKORG");
                String vtweg = table.getString("VTWEG");
                String dwerk = table.getString("DWERK");
                String vmsta = table.getString("VMSTA");
                String vmstd = table.getString("VMSTD");
                String taxm1 = table.getString("TAXM1");
                String atwrt = table.getString("ATWRT");
                String atwrt1 = table.getString("ATWRT1");
                String atwrt2 = table.getString("ATWRT2");
                String atwrt4 = table.getString("ATWRT4");
                String atwrt5 = table.getString("ATWRT5");
                String atwrt6 = table.getString("ATWRT6");
                String atwrt7 = table.getString("ATWRT7");
                String atwrt8 = table.getString("ATWRT8");
                String lgort = table.getString("LGORT");
                String lgpbe = table.getString("LGPBE");
                String kautb = table.getString("KAUTB");
                String ausme = table.getString("AUSME");
                String umrez = table.getString("UMREZ");
                String umren = table.getString("UMREN");
                String qmpur = table.getString("QMPUR");
                String waers = table.getString("WAERS");
                String stprs = table.getString("STPRS");
                material.setMatnr(matnr);
             // 处理SAP的matnr字段
                if(matnr.startsWith("0")) {
                    material.setMatnr1(matnr.replaceFirst("^0*", ""));
                }else {
                   material.setMatnr1(matnr);
                }
                material.setBismt(bismt);
                material.setMaktx(maktx);
                material.setMtart(mtart);
                material.setMtbez(mtbez);
                material.setMeins(meins);
                material.setMatkl(matkl);
                material.setWgbez(wgbez);
                material.setSpart(spart);
                material.setBstme(bstme);
                material.setErsda(ersda);
                material.setLvorm(lvorm);
                material.setErnam(ernam);
                material.setLaeda(laeda);
                material.setAenam(aenam);
                material.setMhdrz(mhdrz);
                material.setMhdhb(mhdhb);
                material.setIprkz(iprkz);
                material.setWerks(werks);
                material.setMtvfp(mtvfp);
                material.setEkgrp(ekgrp);
                material.setXchpf(xchpf);
                material.setDismm(dismm);
                material.setDispo(dispo);
                material.setDisls(disls);
                material.setBstmi(bstmi);
                material.setBstrf(bstrf);
                material.setBeskz(beskz);
                material.setSobsl(sobsl);
                material.setRgekz(rgekz);
                material.setLgpro(lgpro);
                material.setLgfsb(lgfsb);
                material.setDzeit(dzeit);
                material.setPlifz(plifz);
                material.setFhori(fhori);
                material.setEisbe(eisbe);
                material.setStrgr(strgr);
                material.setSbdkz(sbdkz);
                material.setFevor(fevor);
                material.setNcost(ncost);
                material.setMmsta(mmsta);
                material.setVint1(vint1);
                material.setVint2(vint2);
                material.setUeeto(ueeto);
                material.setInsmk(insmk);
                material.setLvorm1(lvorm1);
                material.setBklas(bklas);
                material.setVprsv(vprsv);
                material.setPeinh(peinh);
                material.setEkalr(ekalr);
                material.setHkmat(hkmat);
                material.setMlast(mlast);
                material.setKosgr(kosgr);
                material.setKtgrm(ktgrm);
                material.setMtpos(mtpos);
                material.setVkorg(vkorg);
                material.setVtweg(vtweg);
                material.setDwerk(dwerk);
                material.setVmsta(vmsta);
                material.setVmstd(vmstd);
                material.setTaxm1(taxm1);
                material.setAtwrt(atwrt);
                material.setAtwrt1(atwrt1);
                material.setAtwrt2(atwrt2);
                material.setAtwrt4(atwrt4);
                material.setAtwrt5(atwrt5);
                material.setAtwrt6(atwrt6);
                material.setAtwrt7(atwrt7);
                material.setAtwrt8(atwrt8);
                material.setLgort(lgort);
                material.setLgpbe(lgpbe);
                material.setKautb(kautb);
                material.setAusme(ausme);
                material.setUmrez(umrez);
                material.setUmren(umren);
                material.setQmpur(qmpur);
                material.setWaers(waers);
                material.setStprs(stprs);
                materials.add(material);
            }
            log.info("=========materials.size()======= " +materials.size());
            
            //分批插入数据库，每批500条
            int batchCount = 500;
            int index = 0;
            int size = materials.size();
            if(size > 0) {
                while(true) {
                    if(index + batchCount >= size) {
                        insertMaterials(materials.subList(index, size));
                        insertMaterialHis(materials.subList(index, size));
                        break;
                    }else {
                        insertMaterials(materials.subList(index, index+batchCount));
                        insertMaterialHis(materials.subList(index, index+batchCount));
                        index = index+batchCount;
                    }
                }
            }
        } catch (Exception e) {
            log.error("Failed to sync.", e);
            throw new RuntimeException(e);
        }
        
        return rows;
    }

    public void insertMaterials(List<Material> materials) {
        chartsDao.insertMaterials(materials);
    }

    public void insertMaterialHis(List<Material> materials) {
        chartsDao.insertMaterialHis(materials);
    }

    public List<Material> findByType(String name) {
        return chartsDao.findByType(name);
    }
}
