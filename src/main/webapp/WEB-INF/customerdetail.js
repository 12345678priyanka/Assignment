/**
 * 
 */
document.addEventListener('DOMContentLoaded', function () {
    // Get reference to the element where customer details will be displayed
    const customerDetailsContainer = document.getElementById('customerDetails');

    // Get customer details from the server (you may need to replace this URL)
    const customerUuid = '123'; // Replace with the actual customer UUID
    fetchCustomerDetails(customerUuid)
        .then(customer => {
            // Display customer details in the UI
            displayCustomerDetails(customer);
        })
        .catch(error => {
            console.error('Error fetching customer details:', error);
        });

    // Function to fetch customer details from the server
    async function fetchCustomerDetails(uuid) {
        const customerDetailsURL = `https://example.com/api/customer/details?uuid=${uuid}`;

        const response = await fetch(customerDetailsURL);

        if (!response.ok) {
            throw new Error('Failed to fetch customer details');
        }

        const customer = await response.json();
        return customer;
    }

    // Function to display customer details in the UI
    function displayCustomerDetails(customer) {
        // Example: Update HTML elements with customer information
        customerDetailsContainer.innerHTML = `
            <h2>${customer.FirstName} ${customer.LastName}</h2>
            <p>Email: ${customer.Email}</p>
            <p>Phone: ${customer.Phone}</p>
        ';

        // Example: Add an "Update" button to trigger an update action
        const updateButton = document.createElement('button');
        updateButton.textContent = 'Update Customer';
        updateButton.addEventListener('click', function () {
            // Add logic to navigate to the update page or trigger an update action
            // window.location.href = 'update-customer.html';
            // Alternatively, you can use AJAX to perform an update without navigating
        });

        // Example: Add a "Delete" button to trigger a delete action
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete Customer';
        deleteButton.addEventListener('click', function () {
           
        });

        // Add buttons to the UI
        customerDetailsContainer.appendChild(updateButton);
        customerDetailsContainer.appendChild(deleteButton);
    }
    });