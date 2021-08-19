ALTER TABLE employees ADD CONSTRAINT fk_employees FOREIGN KEY (id) REFERENCES employees (id);
ALTER TABLE companies ADD CONSTRAINT fk_companies FOREIGN KEY (id) REFERENCES companies (id);
CREATE INDEX company_name ON companies (address);
