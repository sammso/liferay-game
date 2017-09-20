create index IX_58E0EDFD on Game_Element (groupId);
create index IX_2AC6D601 on Game_Element (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5EE8C3 on Game_Element (uuid_[$COLUMN_LENGTH:75$], groupId);