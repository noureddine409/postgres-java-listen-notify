CREATE OR REPLACE FUNCTION notify_new_audit_logs_row() RETURNS TRIGGER AS $$
BEGIN
    PERFORM pg_notify('new_audit_logs_row', row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER new_audit_logs_trigger
    AFTER INSERT ON your_table_name
    FOR EACH ROW
    EXECUTE FUNCTION notify_new_audit_logs_row();
