CREATE TABLE IF NOT EXISTS user_sequence (
    name VARCHAR(50) PRIMARY KEY,
    next_val INT NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_employees (
    user_id INT PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(25) NOT NULL,
    locked TINYINT(1) NOT NULL,
    enabled TINYINT(1) NOT NULL,
    name VARCHAR(75) NOT NULL,
    rg VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    phone VARCHAR(20),
    position VARCHAR(100),
    department VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone_ext VARCHAR(8),
    salary DECIMAL(10,2),
    status INT,
    admission_date DATE,
    termination_date DATE,
    address_street VARCHAR(50) NOT NULL,
    address_number VARCHAR(5) NOT NULL,
    address_complement VARCHAR(25) NOT NULL,
    address_city VARCHAR(50) NOT NULL,
    address_district VARCHAR(25) NOT NULL,
    address_zip_code VARCHAR(8) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_admins (
    user_id INT PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(25) NOT NULL,
    locked TINYINT(1) NOT NULL,
    enabled TINYINT(1) NOT NULL
);
