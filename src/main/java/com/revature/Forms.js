document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const gender = document.getElementById('gender').value;
    const birthdate = document.getElementById('birthdate').value;
    const terms = document.getElementById('terms').checked;

    if (!name) {
        alert('Please enter your name.');
        return;
    }

    if (!validateEmail(email)) {
        alert('Please enter a valid email address.');
        return;
    }

    if (password.length < 8) {
        alert('Password must be at least 8 characters long.');
        return;
    }

    if (!gender) {
        alert('Please select your gender.');
        return;
    }

    if (!birthdate) {
        alert('Please enter your birthdate.');
        return;
    }

    if (!terms) {
        alert('You must accept the terms and conditions.');
        return;
    }

    alert('Registration successful!');
});


document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;

    if (email === '' || password === '') {
        alert('Both fields are required.');
        return;
    }

    alert('Login successful!');
});

document.getElementById('feedbackForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const comments = document.getElementById('comments').value;
    const rating = document.getElementById('rating').value;

    if (comments.length < 10) {
        alert('Comments must be at least 10 characters long.');
        return;
    }

    if (rating < 1 || rating > 5) {
        alert('Rating must be between 1 and 5.');
        return;
    }

    alert('Feedback submitted successfully!');
});

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(String(email).toLowerCase());
}
