/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {
    var successMessageElement = document.getElementById("successMessage");
    if (successMessageElement) {
        var successMessage = successMessageElement.value;
        if (successMessage) {
            alert(successMessage);
        }
    }
});

