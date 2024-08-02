# Create HTML Form Structure:

- Create a `form` element with an ID of 'registrationForm', 'loginForm', and 'feedbackForm'.

# Name (Text Input):

- Use the `label` element with the text "Name:" and assign the for attribute with the value "name"
- Use the `input` element with type="text".
- Assign the ID name to this input field.
- Name the input field as "name" using the name attribute.

# Email (Email Input):

-  Use the `label` element with the text "Email:" and assign the for attribute with the value "email"
- Use the `input` element with type="email".
- Assign the ID email to this input field.
- Name the input field as "email" using the name attribute.

# Password (Password Input):

- Use the `label` element with the text "Password:" and assign the for attribute with the value "password"
- Use the `input` element with type="password".
- Assign the ID password to this input field.
- Name the input field as "password" using the name attribute.

# Gender (Select Box):

- Use the `label` element with the text "Gender:" and assign the for attribute with the value "gender"
- Use the `select` element to create a dropdown.
- Assign the ID gender to this select element.
- Name the select box as "gender" using the name attribute.
- Inside the `select` element, use <option> tags to define each option:
    - For Male: <option value="male">Male</option>
    - For Female: <option value="female">Female</option>
    - For Other: <option value="other">Other</option>

# Birthdate (Date Input):

- Use the `label` element with the text "BirthDate:" and assign the for attribute with the value "birthdate"
- Use the `input` element with type="date".
- Assign the ID birthdate to this input field.
- Name the input field as "birthdate" using the name attribute.

# Accept Terms (Checkbox):

- Use the `label` element and assign the for attribute with the value "terms" 
- Use the `input` element with type="checkbox".
- Assign the ID terms to this input field.
- Name the input field as "terms" using the name attribute.
- Set the value to "yes" using the value attribute.
- Provide statement "I accept the terms and conditions".
- close the label tag

# Submit Button:

- Use the `<input>` element with type="submit".
- The text on the button will be "Submit".
- No ID or name is necessary for the submit button.

# LoginEmail (Email Input):

- Use the `label`element with the text "LoginEmail:" and assign the for attribute with the value "loginEmail"

- The label should be linked to the input field using the for attribute, which should match the input field's id. The input field should have the type="email", id="loginEmail", name="loginEmail", and required attributes.

# LoginPassword (Password Input):

- Use the <label> element with the text "LoginPassword:" and assign the for attribute with the value "loginPassword"

- The label should be linked to the input field using the for attribute, which should match the input field's id. The input field should have the type="password", id="loginPassword", name="loginPassword", and required attributes.

# Comments (TextArea Field):

- Use the <label> element with the text "Comments:" and assign the for attribute with the value "comments"

- The label should be linked to the textarea field using the for attribute, which should match the textarea field's id. The textarea field should have the id="comments", name="comments", and required attributes.

# Rating (Rating Input):

- Use the <label> element with the text "Rating:" and assign the for attribute with the value "rating"

- The label should be linked to the input field using the for attribute, which should match the input field's id. The input field should have the type="number", id="rating", name="rating", min="1", max="5", and required attributes.
