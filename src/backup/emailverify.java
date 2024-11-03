/*private void sendVerificationEmail(String email) {
        verificationCode = generateVerificationCode(); 
        String subject = "Your Verification Code";

        String message = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px; }"
                + ".container { background-color: #ffffff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); }"
                + "h2 { color: #333; }"
                + "h4 { color: #333; }"

                + ".code { font-size: 24px; font-weight: bold; color: #ff5722; }"
                + ".footer { font-size: 12px; color: #999; margin-top: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class='container'><center>"
                + "<h2>Your EZ-Wallet Verification Code</h2>"
                + "<h4>Hello "+fname+"!</h4>"
                + "<h3>Your verification code is: <span class='code'>" + verificationCode + "</span></h3>"
                + "<p>Please enter this code in the application to verify your email address.</p>"
                //+ "<center><img src='https://i.ibb.co/KLrZ6PN/Blue-Geometric-Minimalist-Finance-Logo-9.png' alt='Ez-Wallet Logo' style='width: 250px; height: auto;' /></center>"
                + "<p class='footer'>Thank you for using Ez-Wallet!</p>"
                + "</center></div>"
                + "</body>"
                + "</html>";

        // Use SendGrid to send the email
        Email from = new Email("ezwalletlk@proton.me"); // Replace with your SendGrid verified sender email
        String toEmail = email;
        Email to = new Email(toEmail);
        Content content = new Content("text/html", message); // Set content type to HTML
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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"); // Replace with your SendGrid API key
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            
            if (response.getStatusCode() != 202) {
                statusLabel.setText("Error sending email: " + response.getBody());
                System.out.println("SendGrid error: " + response.getStatusCode() + " - " + response.getBody());
            } else {
                statusLabel.setText("Verification code sent to " + email);
            }
        } catch (IOException ex) {
            statusLabel.setText("Error sending email.");
            ex.printStackTrace();
        }

    }*/