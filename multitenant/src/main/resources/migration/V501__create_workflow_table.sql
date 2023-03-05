CREATE TABLE IF NOT EXISTS tenant2schema.workflow_table
(
    wt_id bigint NOT NULL,
    wt_currentstage bigint NOT NULL,
    wt_prevstage bigint NOT NULL,
    wt_readers varchar(255),
    wt_editors varchar(255),
    wt_adminrole varchar(255),
    wt_readerrole varchar(255),
    wt_editorrole varchar(255),
    wt_stageText varchar(255),
    wt_notification_id,
    wt_notification_type varchar(255),
    wt_description varchar(255),
    wt_state bigint
    CONSTRAINT tablefromflyway_pkey PRIMARY KEY (uid)
)