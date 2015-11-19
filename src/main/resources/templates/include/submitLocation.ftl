[#ftl]
[#assign xhtmlCompliant = true in spring/]
    Rate your current location:
    <form id="locationForm" name="locationForm" onSubmit="return onSubmitLocation(this)">
            Name: <input id="name" name="name" type="text" size="32">
            <br/>Rating:
            <select id="rating" name="rating">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
            [#--Latitude: <input type="text" size="4" name="latitude"/>--]
            [#--Longitude: <input type="text" size="4" name="longitude"/>--]
            <input type="submit" id="createLocation" value="create"/>
        [#--</div>--]
    </form>

<p/><p/>
Rate a new location manually:
<form id="locationForm" name="locationForm" onSubmit="return onSubmitLocation(this)">
    Name: <input id="name" name="name" type="text" size="32">
    <br/>Rating:
    <select id="rating" name="rating">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
    </select>
Latitude: <input type="text" size="4" name="latitude"/>
Longitude: <input type="text" size="4" name="longitude"/>
    <input type="submit" id="createLocation" value="create"/>
[#--</div>--]
</form>
