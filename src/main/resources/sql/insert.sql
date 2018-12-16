
INSERT INTO role (id, `role`, name, `describe`) VALUES (1, 'ROLE_ADMIN', '管理员', '管理员');
INSERT INTO role (id, `role`, name,  `describe`) VALUES (2, 'ROLE_TEST1', 'test1', '测试1');
INSERT INTO role (id, `role`, name, `describe`) VALUES (3, 'ROLE_TEST2', 'test2', '测试2');

INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (1, '系统管理', null, 0, 1, null, 'ios-flower');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (2, '菜单2', null, 0, 2, null, 'ios-flower-outline');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (3, '菜单3', null, 0, 3, null, 'ios-rose');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (4, '用户管理', '/base/user', 1, 1, null, 'ios-person');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (5, '菜单管理', '/base/menu', 1, 2, null, 'android-list');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (6, '角色管理', '/base/role', 1, 3, null, 'ios-people');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (7, '子菜单22', '/base/test4', 2, 2, null, 'ios-reverse-camera-outline');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (8, '子菜单31', '/base/test5', 3, 1, null, 'ios-eye');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (9, '子菜单32', '/base/test6', 3, 2, null, 'ios-eye-outline');

INSERT INTO r_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO r_user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO r_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO r_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO r_user_role (user_id, role_id) VALUES (1, 3);
INSERT INTO r_user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO r_user_role (user_id, role_id) VALUES (4, 3);

INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('client', null, '{noop}secret', 'all', 'password,authorization_code,refresh_token,implicit,client_credentials', null, null, null, null, null, null);

