CREATE TABLE `user` (
                            `id`  int(11) NOT NULL ,
                            `created_at`  datetime NULL DEFAULT NULL ,
                            `updated_at`  datetime NULL DEFAULT NULL ,
                            `telphone`  varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
                            `password`  varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
                            `nick_name`  varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
                            `gender`  int(11) NULL DEFAULT NULL ,
                            PRIMARY KEY (`id`),
                            UNIQUE INDEX `telphone_unique_index` (`telphone`) USING BTREE
)
    ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=DYNAMIC
;
