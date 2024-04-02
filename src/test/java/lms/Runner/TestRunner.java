package lms.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(

			plugin = {"pretty", "html:target/LMS.html",
					"json:target/LMS.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
					},    //reporting purpose
                 
			monochrome=false,  //console output color
			features = {"src/test/resources/features/1UserLogin.feature",
					"src/test/resources/features/2_Program/2_1_PostReqProgram.feature",
					"src/test/resources/features/2_Program/2_2_GetReqAllProgram.feature",
					"src/test/resources/features/2_Program/2_3_GetReqProgramID.feature",
					"src/test/resources/features/2_Program/2_5_UpdateProgramById.feature",
					"src/test/resources/features/2_Program/2_6_UpdateProgramByName.feature",
					//"src/test/resources/features/7DeleteProgramByName.feature",
					//"src/test/resources/features/6DeleteProgramById.feature",
					"src/test/resources/features/2_Program/2_4_GetAllProgramsWithAdmins.feature",
          "src/test/resources/features/3BatchModule.feature",
           "src/test/resources/features/4UserModule.feature",
					"src/test/resources/features/5UserRollProgramBatchMap.feature",
          "src/test/resources/features/9UserLogOut.feature",
          "src/test/resources/features/8DeleteAllRequest.feature"
					}, //location of feature files		

			glue= {"lms.StepDefinitions","lms.StepDefinitions.stepDefinitionsProgram","Hooks"} //location of step definition files
		)
public class TestRunner {
	

}