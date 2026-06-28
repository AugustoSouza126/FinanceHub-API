CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE users (

    id UUID DEFAULT gen_random_uuid(),

    name VARCHAR(100) NOT NULL,

    email VARCHAR(150) NOT NULL,

    password VARCHAR(255) NOT NULL,

    profile_image_url VARCHAR(255),

    created_at TIMESTAMP WITH TIME ZONE NOT NULL,

    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT pk_users PRIMARY KEY (id),

    CONSTRAINT uk_users_email UNIQUE (email)

);
