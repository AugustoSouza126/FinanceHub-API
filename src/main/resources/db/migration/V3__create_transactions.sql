CREATE TABLE transactions (

                              id BIGSERIAL PRIMARY KEY,

                              description VARCHAR(255) NOT NULL,

                              amount NUMERIC(10,2) NOT NULL,

                              date DATE NOT NULL,

                              category_id BIGINT NOT NULL,

                              user_id BIGINT NOT NULL,

                              created_at TIMESTAMP NOT NULL,

                              updated_at TIMESTAMP,

                              CONSTRAINT fk_transaction_category
                                  FOREIGN KEY (category_id)
                                      REFERENCES categories(id),

                              CONSTRAINT fk_transaction_user
                                  FOREIGN KEY (user_id)
                                      REFERENCES users(id)

);