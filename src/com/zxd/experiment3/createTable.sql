CREATE TABLE `card_info` (
                             `card_id` varchar(6) NOT NULL COMMENT '���п���',
                             `password` varchar(6) DEFAULT NULL COMMENT '����',
                             `money` bigint unsigned DEFAULT NULL COMMENT '���п����',
                             PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `admin_info` (
                              `admin_id` varchar(8) NOT NULL,
                              `password` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;