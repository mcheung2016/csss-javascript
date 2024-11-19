document.getElementById('signupForm').addEventListener('submit', function (event) {
    
    const name = document.getElementById('name').value.trim();
    const email = document.getElementById('email').value.trim();
    const phone = document.getElementById('tel').value.trim();
    const password = document.getElementById('password').value.trim();
    const terms = document.getElementById('terms').checked;

    let isValid = true;

    if (name === '') {
        document.getElementById('nameError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('nameError').style.display = 'none';
    }

    if (!validateEmail(email)) {
        document.getElementById('emailError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('emailError').style.display = 'none';
    }

    if (phone === '' || phone.length < 10) {
        document.getElementById('telError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('telError').style.display = 'none';
    }

    if (password.length < 8) {
        document.getElementById('passwordError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('passwordError').style.display = 'none';
    }

    if (!terms) {
        document.getElementById('termsError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('termsError').style.display = 'none';
    }

    if (!isValid) {
        event.preventDefault();
    }
});

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}
