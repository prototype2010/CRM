<script>
    $(function () {
        $("#datepicker").datepicker({
            dateFormat: "yy-mm-dd"
        });
        $("#anim").change(function () {
            $("#datepicker").datepicker("option", "showAnim", $(this).val());
        });
    });
    var context = "${CONTEXT}";
</script>

<div class="controlPanel">

</div>

<div class="dataField">
    <div class="newSaleBlock">
        <form action="/admin-expenses-new.php" method="post">
            <h2 class="tableHeader"> New Expense</h2>

            <p class="insideInputField">Type <input type="text" name="type" required="required" ></p>

            <p class="insideInputField">Amount <input type="number" name="sum" min="0" step="1000" required="required"></p>

            <p class="insideInputField">Comment <input type="text" name="comment" required="required"></p>

            <p class="insideInputField">Date <input type="text" name="date" required="required" id="datepicker" placeholder="Click here to set date"></p>

            <p class="insideInputField"><input type="submit" value="Add new"></p>
        </form>
    </div>
</div>

