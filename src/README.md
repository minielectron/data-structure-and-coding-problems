 ## How to test the Auto Read OTP?

### Auto read without user consent

Step 1: Open the sample app and select `OTP Text Field` from list

Copy the below sms and paste in message box of emulator/phone and send.
```text
Your OTP is 123456

AyCqfYYJjlZ
```

Once OTP is sent successfully you will see the OTP field will be populated.

### Auto read with user consent

Step 1: Open the sample app and select `OTP With Consent` from the list.

Copy the below sms and paste in message box of emulator/phone and send.
```text
Your OTP is 123456
```
Once OTP is sent successfully, you will see a pop-up asking the consent, on allowing the OTP field will be populated.
 
*Note that if you are sending through the mobile number, that contact shouldn't be
saved in your contact list.*
 
 #### References 
 - Creating message for OTP with user consent - [click here](https://developers.google.com/identity/sms-retriever/user-consent/request#2_start_listening_for_incoming_messages)
 - Creating message for OTP without user consent - [click here](https://developers.google.com/identity/sms-retriever/verify#1_construct_a_verification_message)

