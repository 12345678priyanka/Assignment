/**
 * 
 */
document.addEventListener('DOMContentLoaded', function () {
    // Get references to HTML elements
    const loginForm = document.getElementById('loginForm');
    const loginResult = document.getElementById('loginResult');

    // Add event listener to the login form
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission behavior

        // Get user inputs
        const loginId = document.getElementById('loginId').value;
        const password = document.getElementById('password').value;

        // Make an asynchronous request to authenticate the user
        authenticateUser(loginId, password)
            .then(token => {
                // Display success message and store the token in localStorage
                loginResult.innerHTML = 'Login Successful';
                localStorage.setItem('bearerToken', token);
            })
            .catch(error => {
                // Display error message
                loginResult.innerHTML = 'Login Failed: ' + error.message;
            });
    });

    // Function to authenticate the user
    async function authenticateUser(loginId, password) {
        const authenticationURL = 'https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp';

        const response = await fetch(authenticationURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                login_id: loginId,
                password: password,
            }),
        });

        if (!response.ok) {
            throw new Error('Authentication Failed');
        }

        const data = await response.json();

        // Check if the response contains a bearer token
        if (data && data.token) {
            return data.token;
        } else {
            throw new Error('Invalid Token');
        }
    }
});