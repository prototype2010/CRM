/**
 * Created by Boris on 11.05.2016.
 */

$(function () {
    $("#datepicker").datepicker({
        dateFormat: "yy-mm-dd"
    });
    $("#anim").change(function () {
        $("#datepicker").datepicker("option", "showAnim", $(this).val());
    });
});
var context = "${CONTEXT}";
function createStudentButton() {
    var inputSurname = document.getElementById('surname').value;
    alert(inputSurname.value);

}
