document.getElementById('enterNumbersForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission behavior

    var numbers = document.getElementById('numbers').value; // Get the entered numbers

    // Asynchronous POST request to process the numbers
    fetch('/process-numbers', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: 'numbers=' + encodeURIComponent(numbers), // Encode the numbers
    })
    .then(response => {
        if (response.ok) {
            return response.json(); // Parse response JSON
        } else {
            throw new Error('Error processing numbers: ' + response.statusText);
        }
    })
    .then(data => {
        // Redirect to the page to display the result
        window.location.href = '/show-input?id=' + data.id; // Assuming the response contains the ID of the saved input
    })
    .catch(error => {
        console.error('Error processing numbers:', error);
    });
});
