window.alert("Testing")
function validateForm(action) {
        let valid = true;

        document.getElementById('customizedError').style.display = "none";
        document.getElementById('originalError').style.display = "none"

        let customized = document.getElementById('customizedFld').value;
        if (customized == null || customized.trim() === "") {
            document.getElementById('customizedError').style.display = "block";
            valid = false;
        }
        if (action === "customizeBtn"
            && (customized == null || customized.trim() === "")) {
            originalError
            document.getElementById('originalError').style.display = "block";
            valid = false;
        }
}
