<?php
  // Replace 'your-email@example.com' with your real receiving email address
  $receiving_email_address = 'your-email@example.com';

  if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Check if PHP Email Form library exists
    if (file_exists($php_email_form = '../assets/vendor/php-email-form/php-email-form.php')) {
      include($php_email_form);
    } else {
      die('Unable to load the "PHP Email Form" Library!');
    }

    $contact = new PHP_Email_Form;
    $contact->ajax = true;
    
    // Assign form inputs to PHP_Email_Form variables
    $contact->to = $receiving_email_address;
    $contact->from_name = $_POST['name'];
    $contact->from_email = $_POST['email'];
    $contact->subject = $_POST['subject'];

    // Uncomment below code if you want to use SMTP to send emails. Enter your correct SMTP credentials
    /*
    $contact->smtp = array(
      'host' => 'example.com',
      'username' => 'example',
      'password' => 'pass',
      'port' => '587'
    );
    */

    // Add messages to the email form
    $contact->add_message($_POST['name'], 'From');
    $contact->add_message($_POST['email'], 'Email');
    $contact->add_message($_POST['message'], 'Message', 10);

    // Send email and output result
    if ($contact->send()) {
      echo 'Email sent successfully!';
    } else {
      echo 'Failed to send email.';
    }
  } else {
    echo 'Invalid request method.';
  }
?>
