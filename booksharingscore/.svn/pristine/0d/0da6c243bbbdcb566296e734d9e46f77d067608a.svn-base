begin
  sys.dbms_scheduler.create_job(job_name            => 'SI_TEST.INVENTORY_STATISTICS',
                                job_type            => 'PLSQL_BLOCK',
                                job_action          => 'begin
    statistics_material_inventory(to_char(sysdate-1,''yyyyMM''));
  end;',
                                start_date          => to_date('01-12-2018 00:00:00', 'dd-mm-yyyy hh24:mi:ss'),
                                repeat_interval     => 'Freq=Monthly',
                                end_date            => to_date(null),
                                job_class           => 'DBMS_JOB$',
                                enabled             => true,
                                auto_drop           => false,
                                comments            => '');
end;
/
