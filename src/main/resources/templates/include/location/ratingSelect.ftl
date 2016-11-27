[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
[#macro ratingSelectList]
    <select id="rating" name="rating">
        <label for="rating">Rating: </label>
        <option value="1">1 (lousy)</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10 (amazeballs)</option>
    </select>
<script lang="javascript">
    var foo =  '${location.name}';
    var ratingWholeNum = Math.round('${location.averageRating}');
    var ratingObj = document.getElementById("rating").options;
    for (var i = 0; i < ratingObj.length; i++) {
        if (ratingObj[i].value == ratingWholeNum) {
            ratingObj[i].selected = 'selected';
        }
    }
</script>
    [/#macro]
[/#escape]