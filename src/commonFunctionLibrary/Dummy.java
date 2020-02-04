package commonFunctionLibrary;

public class Dummy {

	public static void main(String[] args) throws Throwable {
		
          ERP_Functions erp=new ERP_Functions();
         String resultoflaunchApp = erp.launchAPP("http://webapp.qedge.com/login.php");
         System.out.println(resultoflaunchApp);
        String resultoflogin =erp.login("admin", "master");
        System.out.println(resultoflogin);
        
        String resultofsuppliercreation=erp.supplier("demosname", "demoaddress", "democity","democountry","democperson","demopnumber","demoemail", "demomnumber","demonotes");
        System.out.println(resultofsuppliercreation);
        
        String resultoflogout=erp.logout();
        System.out.println(resultoflogout);
        
        erp.closebrw();
	}

}
