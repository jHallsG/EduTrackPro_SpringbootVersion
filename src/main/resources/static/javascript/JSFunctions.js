/**
 * 
 */
document.addEventListener("DOMContentLoaded", function() {
    var requestMessageElement = document.getElementById("messageSent");
    if (requestMessageElement) {
        var requestSent = requestMessageElement.value;
        if (requestSent) {
            alert(requestSent);
        }
    }
});


document.addEventListener("DOMContentLoaded", function() {
    var successMessageElement = document.getElementById("successMessage");
    if (successMessageElement) {
        var successMessage = successMessageElement.value;
        if (successMessage) {
            alert(successMessage);
        }
    }
});



document.addEventListener('DOMContentLoaded', function() {
    const deleteLinks = document.querySelectorAll('.delete-link');

    deleteLinks.forEach(function(link) {
        link.addEventListener('click', function(event) {
            if (!confirm('Confirm delete?')) {
                event.preventDefault();
            }
        });
    });
});