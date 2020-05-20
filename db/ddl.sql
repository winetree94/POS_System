CREATE DATABASE possystem;
CREATE USER 'possystem'@'%' IDENTIFIED BY 'possystem';
GRANT ALL PRIVILEGES ON possystem.* TO 'possystem'@'%';

use possystem;

create table if not exists AUTH
(
    AUTH_KEY      varchar(20) null,
    AUTHSTATUS    varchar(2)  null,
    SERVICE_EMAIL varchar(50) null,
    REGDATE       date        null
);

create table if not exists SERVICE_ACCOUNT
(
    SERVICE_ID    varchar(20)         not null
        primary key,
    SERVICE_EMAIL varchar(50)         not null,
    SERVICE_PW    varchar(20)         not null,
    SERVICE_TYPE  char(2) default 'U' not null,
    REGDATE       datetime            not null,
    DELFLAG       char(2) default 'N' not null
);

create table if not exists SERVICE_BOARD
(
    BOARD_SEQ  int auto_increment
        primary key,
    SERVICE_ID varchar(20)         not null,
    READCOUNT  int     default 0   not null,
    REGDATE    datetime            not null,
    TITLE      varchar(50)         not null,
    CONTENT    varchar(4000)       not null,
    REF        int                 not null,
    STEP       int                 not null,
    DEPTH      int                 not null,
    TYPE       char(2) default 'Q' not null,
    DELFLAG    char(2) default 'N' not null,
    constraint SERVICE_ID_FK
        foreign key (SERVICE_ID) references SERVICE_ACCOUNT (SERVICE_ID)
);

create table if not exists SERVICE_FILE
(
    FILE_SEQ     int auto_increment
        primary key,
    BOARD_SEQ    int                 not null,
    ORIGIN_FNAME varchar(500)        not null,
    STORED_FNAME varchar(500)        not null,
    FILE_SIZE    int                 not null,
    REGDATE      datetime            not null,
    DELFLAG      char(2) default 'N' not null,
    constraint SERVICE_FILE_FK
        foreign key (BOARD_SEQ) references SERVICE_BOARD (BOARD_SEQ)
);

create table if not exists SERVICE_STORE
(
    STORE_SEQ     int auto_increment
        primary key,
    SERVICE_ID    varchar(20)         not null,
    STORE_NAME    varchar(50)         not null,
    STORE_DETAIL  varchar(4000)       not null,
    STORE_TYPE    varchar(30)         not null,
    STORE_ADDRESS varchar(200)        not null,
    STORE_TEL     varchar(20)         not null,
    STORE_HOUR    varchar(50)         not null,
    DELFLAG       char(2) default 'N' not null,
    REGDATE       datetime            null,
    constraint SERVICE_STORE_FK
        foreign key (SERVICE_ID) references SERVICE_ACCOUNT (SERVICE_ID)
);

create table if not exists STORE_ACCOUNT
(
    USER_ID      varchar(20)         not null
        primary key,
    SERVICE_ID   varchar(20)         not null,
    USER_EMAIL   varchar(50)         not null,
    USER_PW      varchar(20)         not null,
    USER_TYPE    char(2) default 'C' not null,
    USER_REGDATE datetime            not null,
    POINT        int     default 0   not null,
    DELFLAG      char(2) default 'U' not null,
    constraint SERVICE_ACCOUNT_USER_ID_FK
        foreign key (SERVICE_ID) references SERVICE_ACCOUNT (SERVICE_ID)
);

create table if not exists STORE_CASHBOOK
(
    CASH_SEQ     int auto_increment
        primary key,
    STORE_SEQ    int                                not null,
    CASH_DATE    datetime default CURRENT_TIMESTAMP not null,
    CASH_DEPOSIT int                                null,
    CASH_BALANCE int      default 0                 not null,
    constraint STORE_CASHBOOK_STORE_SEQ_FK
        foreign key (STORE_SEQ) references SERVICE_STORE (STORE_SEQ)
);

create table if not exists STORE_CATEGORY
(
    MENU_SEQ     int auto_increment
        primary key,
    STORE_SEQ    int                 not null,
    MENU_NAME    varchar(20)         not null,
    CATEG_NAME   varchar(20)         not null,
    MENU_INFO    varchar(50)         not null,
    ORIGIN_FNAME varchar(2000)       not null,
    STORED_FNAME varchar(2000)       not null,
    MENU_PRICE   int     default 0   not null,
    DELFLAG      char(2) default 'N' not null,
    constraint STORE_CATEGORY_STORE_SEQ_FK
        foreign key (STORE_SEQ) references SERVICE_STORE (STORE_SEQ)
);

create table if not exists STORE_TABLE
(
    TABLE_SEQ   int auto_increment
        primary key,
    STORE_SEQ   int                 not null,
    TABLE_NAME  varchar(20)         not null,
    RESERVATION char(2) default 'D' not null,
    MIN_PEOPLE  int     default 1   not null,
    MAX_PEOPLE  int                 not null,
    DELFLAG     char(2) default 'N' not null,
    constraint STORE_TABLE_STORE_SEQ_FK
        foreign key (STORE_SEQ) references SERVICE_STORE (STORE_SEQ)
);

create table if not exists STORE_ORDER
(
    ORDER_SEQ  int auto_increment
        primary key,
    STORE_SEQ  int                                not null,
    TABLE_SEQ  int                                not null,
    MENU_SEQ   int                                not null,
    MAKE       char(2)  default 'N'               not null,
    ORDER_DATE datetime default CURRENT_TIMESTAMP not null,
    MENU_PRICE int                                not null,
    REF        int                                not null,
    DELFLAG    char(2)                            not null,
    PAYED      char(2)  default 'N'               not null,
    constraint STORE_ORDER_MENU_SEQ_FK
        foreign key (MENU_SEQ) references STORE_CATEGORY (MENU_SEQ),
    constraint STORE_ORDER_STORE_SEQ_FK
        foreign key (STORE_SEQ) references STORE_TABLE (STORE_SEQ),
    constraint STORE_ORDER_TABLE_SEQ_FK
        foreign key (TABLE_SEQ) references STORE_TABLE (TABLE_SEQ)
);

create table if not exists STORE_INVOICE
(
    INVOICE_SEQ     int auto_increment
        primary key,
    STORE_SEQ       int                                not null,
    TABLE_SEQ       int                                not null,
    REF             int                                not null,
    MENU_AMOUNT     int                                not null,
    TAX_AMOUNT      int                                not null,
    TOTAL_AMOUNT    int                                not null,
    DISCOUNT_AMOUNT int                                not null,
    FINAL_AMOUNT    int                                not null,
    PAID_DATE       datetime default CURRENT_TIMESTAMP not null,
    PAYMENT_METHOD  varchar(20)                        not null,
    DELFLAG         char(2)  default 'N'               not null,
    constraint STORE_INVOICE_STORE_SEQ_FK
        foreign key (STORE_SEQ) references STORE_ORDER (STORE_SEQ),
    constraint STORE_INVOICE_TABLE_SEQ_FK
        foreign key (TABLE_SEQ) references STORE_ORDER (TABLE_SEQ)
);

create table if not exists STORE_RESERVATION
(
    RESERV_SEQ    int auto_increment
        primary key,
    STORE_SEQ     int                                not null,
    TABLE_SEQ     int                                not null,
    USER_ID       varchar(20)                        not null,
    RESERV_TIME   datetime default CURRENT_TIMESTAMP not null,
    RESERV_PEOPLE int                                not null,
    DELFLAG       char(2)  default 'N'               not null,
    constraint STORE_RESERVATION_STORE_SEQ_FK
        foreign key (STORE_SEQ) references STORE_TABLE (STORE_SEQ),
    constraint STORE_RESERVATION_TABLE_SEQ_FK
        foreign key (TABLE_SEQ) references STORE_TABLE (TABLE_SEQ),
    constraint STORE_RESERVATION_USER_ID_FK
        foreign key (USER_ID) references STORE_ACCOUNT (USER_ID)
);

