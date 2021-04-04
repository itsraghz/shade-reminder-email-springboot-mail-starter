# Things to Do

## Must Have
1. (*) Externalize all the values
    * From email
    * To Recipients
    * SMTP properties etc.,
2. Add the placeholder for YYYY-MMM in the Shade Reminder Email.   
3. Bring some dynamism on the test emails  with a placeholder for a random number or YYYYMMDDHHMMSS or 
   something similar - in the Email Subject and/or Body.
4. Automatically send the first/initial email if needed, and then the subsequent ones will be for the reminders
5. Can save the output somewhere for logging (report with the full HTML file as well)
6. Can have a flag marked in a tracker file for the reference for each email.
7. Add a placeholder for the MMM YYYY in the body of the email (April 2021)
8. (*) FIXED - Bug - `mail.cc` is not reflecting!
9. Add a PS (PostScript) in the config file and provision it with a visual highlighted text in the email body
10. Facility to add a BCc recipient
11. Make a Web Application if possible to have a different templates - for the reminders, and any adhoc emails.


## Nice to have

1. Verify the emails sent via IMAP Protocol using JavaMail API - Unit Testing
2. Add Logging instead of SOP
3. Validate the emails sent if any previously
4. Validate the contents and email attributes before sending