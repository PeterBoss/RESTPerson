$(document).ready(function () {

    $.ajax({
        url: "http://localhost:8080/REST_JAX-RS_part2/api/person/"
    }).then(function (data) {
        var table = $("<table></table>");
        $.each(data, function (idx, person) {
            var row = $("<tr></tr>");
            row.append($("<td></td>").html(person.id));
            row.append($("<td></td>").html(person.fName));
            row.append($("<td></td>").html(person.lName));
            row.append($("<td></td>").html(person.phone));

            table.append(row);
        });
        $(document.body).append(table);

        var reload = $('<input type="button" id="reload" value="Reload Data"/>');
        $("body").append(reload);

        $("#reload").click(function () {
            location.reload();
        });
        
        var add = $('<input type="button" id="new" value="Add New Person"/>');
        $("body").append(add);
    });



});