# Version History

1. V 1.0 - 12 Mar 2021 
    * Initial Version
   

2. V2.0 - 12 Mar 2021
    * ToDo.md added
    * versionHistory.md added
   
3. V3.0 - 12 Mar 2021, Friday

   * SMTP config moved to `application.resources` properties file
   * Added `EmailConfig.java`, `StringUtil.java` files
   
4. V4.0 - 12 Mar 2021, Friday

   * Modified the 'smtp.password' key to 'smtp.secret' in the `application.properties` file
      due to the issue -> `SMTP credentials exposed on GitHub`
   * Used the `mail.from` and `mail.to` properties from the config file     
    
5. V5.0 - 12Mar2021 Friday
   * Modified the 'smtp.secret' key to 'smtp.code' in the `application.properties` file
     due to the issue -> https://dashboard.gitguardian.com/workspace/95623/incidents/398884
   