function analyzeReview() {
    const reviewInput = document.getElementById('reviewInput').value;
    if (reviewInput.trim() === '') {
        alert('Please enter a review before analyzing.');
        return;
    }

    // Send the review to the server for sentiment analysis
    // Replace 'http://your-server-url/analyzeSentiment' with the actual API endpoint
    fetch('/analyzeSentiment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ review: reviewInput })
    })
    .then(response => response.text())
    .then(sentiment => {
        const sentimentResult = document.getElementById('sentimentResult');
        sentimentResult.innerHTML = `<h2>Analysis Result:</h2><p>${sentiment}</p>`;
    })
    .catch(error => {
        console.error('Error analyzing the review:', error);
        alert('An error occurred during sentiment analysis.');
    });
}
