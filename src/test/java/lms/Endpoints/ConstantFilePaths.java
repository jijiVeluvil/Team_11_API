package lms.Endpoints;

public class ConstantFilePaths {
	
	public static final String USER_MODULE_DATA = "./src/test/resources/LMSPhase2TestData.xlsx";
	public static final String UPDATE_USER_QUERRY = "select * from UpdateUser Where run = 'Yes'";
	public static final String UPDATE_USER_WITH_MANDATEFIELDS = "select * from UpdateUser Where run = 'No'";
	public static final String UPDATE_USER_WITH_INVALID_FIELDS_QUERRY = "select * from UpdateUser where run = '3'";
	public static final String UPDATE_USER_ROLEID_QUERRY = "select * from UpdateUser where run ='4'";
	public static final String UPDATE_USER_ROLEID_WITH_INVALID_VALUES_QUERRY = "select * from UpdateUser where run ='9'";
	
	public static final String UPDATE_USER_ROLEID_STATUS_QUERRY = "select * from UpdateUser where run ='5'";
	public static final String UPDATE_USER_ROLEID_STATUS_WITH_INVALID_QUERRY = "select * from UpdateUser where run ='10'";
	public static final String UPDATE_USER_ROLEID_STATUS_WITh_UNASSIGNED_ROLEID_QUERRYY = "select * from UpdateUser where run ='11'";
	
	public static final String UPDATE_USER_LOGIN_STATUS_QUERRY = "select * from UpdateUser where run ='6'";
	public static final String UPDATE_USER_LOGIN_STATUS_WITH_INVALID_QUERRY = "select * from UpdateUser where run ='12'";
	
	public static final String UPDATE_USER_PROGRAM_BATCH_QUERRY = "select * from UpdateUser where run ='8'";
	public static final String UPDATE_USER_PROGRAM_BATCH_INVALID_QUERRY = "select * from UpdateUser where run ='13'";
	
	public static final String UERMODULE_EXCELDATA = "./src/test/resources/UserModule.xlsx";
	public static final String STATUS_CODE_QUERRY = "select expectedStatusCode from Sheet1 where Run='yes'";
	public static final String EXCEL_DATA_QUERRY_1 = "select * from Sheet1 where Run = '1'";
	public static final String EXCEL_DATA_QUERRY_2= "select * from Sheet1 where Run = '2'";
	public static final String EXCEL_DATA_QUERRY_3= "select * from Sheet1 where Run = '3'";
	public static final String EXCEL_DATA_QUERRY_4 = "select * from Sheet1 where Run = '4'";
	public static final String EXCEL_DATA_QUERRY_5 = "select * from Sheet1 where Run = '5'";
	public static final String POST_USER_JSON = "./src/test/resources/postUser.json";
	public  static final String UPDATE_USER_SCHEMA_VALID = "./src/test/resources/UpdateUserByuserId.json";
	
	public static final String  BASE_URL = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	

	//User Login
	public static final String USER_LOGIN_INVALID_ENDPOINT = "/login1";
	public static final String USER_LOG_OUT="/logoutlms";
		

	public static final String  INVALID_BASE_URL = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms1";
	

	//userModuleEndpoints
	public static final String USER_LOGIN_ENDPOINT = "/login";
	public static final String All_USERS_WITH_ROLES_ENDPOINT = "/users/roles";
	public static final String ALL_USERS_WITH_ROLES_INVALID_ENDPOINT = "/users/role";

	public static final String SAVE_PROGRAM ="/saveprogram";
	public static final String GET_ALLPROGRAM ="/allPrograms";
	public static final String GET_ALLPROGRAM_INVALID_ENDDPOINT ="/allProgram";
	public static final String GET_ALLPROGRAMID ="/programs/{programId}";
	public static final String UPDATE_BY_PID ="/putprogram/{programId}";
	public static final String UPDATE_BY_PNAME = "/program/{programName}";
	public static final String GET_ALLPROGRAMID_INVALID ="/programsInvalid/{programId}";
	public static final String DELETE_BY_PID ="/deletebyprogid/{programId}";
	public static final String DELETE_BY_PNAME ="/deletebyprogname/{programName}";
	
	//BatchModuleEndPoint
	public static final String ALL_BATCHES_WITH_ENDPOINTS ="/batches";
	public static final String ALL_BATCHES_WITH_INVALIDENDPOINTS="/invalidbatches";
	
	public static final String BATCH_SEARCH_STRING="/batches?searchString=";
	//Batch--->ProgramId
	
	public static final String PUT_BATCH_WITH_BATCH_ID_ENDPOINT="/batches/";
	
	public static final String BATCH_TEST_DATA="./src/test/resources/BatchModule.xlsx";
	//Schema
	public static final String POST_BATCH_SCHEMA_FILE_PATH="./src/test/resources/POSTBatch.json";
	
	public static final String BATCH_QUERRY = "select  * from BatchName where run='Yes'";
	public static final String BATCH_QUERRY1 = "select  * from BatchName where run='1'";//Invalid Batch Id
	public static final String BATCH_QUERRY2 = "select  * from BatchName where run='2'";//Missing mandatory fields
	public static final String BATCH_QUERRY3 = "select  * from BatchName where run='3'";//Invalid Data Put And Post
	public static final String BATCH_QUERRY4 = "select  * from BatchName where run='4'";//Create new Batch
	public static final String BATCH_QUERRY5 = "select  * from BatchName where run='5'";//Missing for post
	public static final String BATCH_QUERRY6 = "select  * from BatchName where run='6'";//Missing additional field
	public static final String BATCH_QUERRY7 = "select  * from BatchName where run='7'";//Invalid Program Id Post
	public static final String BATCH_QUERRY8 = "select  * from BatchName where run='8'";
	
	public static final String GET_BATCH_WITH_BATCH_ID_ENDPOINT="/batches/batchId/";
	public static final String GET_BATCH_WITH_BATCH_Name_ENDPOINT="/batches/batchName/";//{batchName}
	public static final String GET_BATCH_WITH_PROGRA_ID_ENDPOINT="/batches/program/";//:/batches/program/{programId}
	public static final String GET_BATCH_WITH_INVALID_PROGRA_ID_ENDPOINT="/batches/invalidprogram/";
	public static final String POST_BATCH_WITH_INVALID_ENDPOINT="/InvalidProgram/";
	public static final String PUT_BATCH_WITH_DELETE_ENDPOINT="/batches/";
	//Delete
	public static final String DELETE_BATCH_ID_ENDPOINT="/batches/";
	//User Role Map Batch Controller
	public static final String USER_ROLE_PROGRAM_BATCH_MAP_ENDPOINT="/userRoleProgramBatchMap"; //Get All Users
	public static final String USER_ROLE_PROGRAM_BATCH_MAP_BY_ADMIN_ID_ENDPOINT="/userRoleProgramBatchMap/";
	
	public static final String USER_ROLE_PROGRAM_BATCH_MAP_BY_ADMIN_ID_DELETE_ENDPOINT="/userRoleProgramBatchMap/deleteAll/";
	
	//User LogOut
	
	public static final String USER_LOGOUT_ENDPOINT="/logoutlms";
	public static final String USER_LOGOUT_INVALID_ENDPOINT="/invalidlogoutlms";
	
	

	public static final String UPDATE_USER_ROLEID_ENDPOINT = "/users/roleId/";
	public static final String UPDATE_USER_ROLEID_INVALID_ENDPOINT = "/users/roleI/";
	public static final String UPDATE_USER_BY_ID_ENDPOINT = "/users/";
	public static final String UPDATE_USER_ROLEID_STATUS_ENDPOINT = "/users/roleStatus/";
	public static final String UPDATE_USER_ROLEID_STATUS_INVALIDENDPOINT = "/users/roleStatu/";
	
	public static final String UPDATE_USER_LOGIN_STATUS_ENDPOINT = "/users/userLogin/";
	public static final String UPDATE_USER_PROGRAM_BATCH_ENDPOINT = "/users/roleProgramBatchStatus/";
	public static final String UPDATE_USER_PROGRAM_BATCH_INVALID_ENDPOINT = "/users/roleProgramBatchStatu/";
	
	public static final String GET_ALL_USERS_WITH_FILTERS_ENDPOINT = "/v2/users";
	public static final String GET_ALL_USERS_WITH_FILTERS_INVALID_ENDPOINT = "/V2/usrrr";
	
	public static final String DELETE_USER_WITH_USERID_ENDPOINT = "/users/";
	public static final String DELETE_USER_WITH_USERID_INVALID_ENDPOINT = "/user/";
	
	public static final String CREATE_USERS_WITH_ROLES = "/users/roleStatus";
	public static final String GET_ALL_ROLES_INVALID_ENDPOINT = "/users/role";
	public static final String GET_ALL_ROLES = "/users/roles";
	public static final String GET_ALL_ADMINS = "/users";
	public static final String GET_ALL_ADMINS_INVALID_ENDPOINT = "/user";
	public static final String GET_USER_BY_ADMINID = "/users/";
	public static final String GET_USER_BY_ADMINID_INVALID_ENDPOINT = "/user/";
	public static final String GET_ALL_ACTIVE_ADMINS = "/users/activeUsers";
	public static final String GET_ALL_ACTIVE_ADMINS_INVALID_ENDPOINT = "/user/activeUsers";
	public static final String GET_ALL_ACT_INACT_ADMINS = "/users/byStatus";
	public static final String GET_ALL_ACT_AND_INACT_ADMINS_INVALID_ENDPOINT = "/User/Statussss";
	public static final String GET_INACT_AND_ACT_ADMINS_BY_ROLEID = "/users/byStatus?id=R03";
	public static final String GET_INACT_AND_ACT_ADMINS_BY_INVALID_ROLEID = "/users/byStatus?id=R05";
	public static final String GET_ADMIN_BY_PROG_BATCH = "/users/programBatch/";
	public static final String GET_ADMIN_BY_PROG_BATCH_INVALID_ENDPOINT = "/user/programBatch/";
	public static final String GET_ADMIN_BY_PROG_ID = "/users/programs/";
	public static final String GET_ADMIN_BY_PROG_ID_INVALID_ENDPOINT = "/user/program/";
	public static final String GET_ADMIN_BY_ROLE_ID = "/users/roles/";
	public static final String GET_ADMIN_BY_ROLE_ID_INVALID_ENDPOINT = "/User/RRRole/";

	
	
	
}
