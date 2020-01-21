INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('admin', 'd1bb9240b8a4d43997d36e73440bef286402265ce5157458a0f47b3f443ddbc0186979023d90680f', 'read,write',
	'password,authorization_code,refresh_token,client_credentials', null, 'ROLE_ADMIN', 36000, 36000, null, true);
