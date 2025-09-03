-- Cria a tabela 'tb_event'
CREATE TABLE tb_event (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    location VARCHAR(255),
    organizer VARCHAR(255),
    identifier VARCHAR(255) UNIQUE NOT NULL,
    capacity INTEGER NOT NULL,
    start_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    event_type VARCHAR(50) NOT NULL -- Está usando o @Enumerated no lado da infra
);
