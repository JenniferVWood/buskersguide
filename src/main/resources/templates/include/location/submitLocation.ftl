[#ftl]
[#assign xhtmlCompliant = true in spring/]
<fieldset>
    <div i="rateCurrenLocation">
        <b>Rate your current location using your device's GPS:</b>
        <form id="locationForm" name="locationForm" onSubmit="return onSubmitLocation(this)">
            Name: <input id="name" name="name" type="text" size="32">
            <br/>Rating:
            <select id="rating" name="rating">
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
            <input type="submit" id="createLocation" value="create"/>
        </form>
    </div>
    <hr width="30%" align="left"/>
    <div id="rateLocationManually">
    <b>Rate a new location manually by entering coordinates:</b>
        <form id="manualLocationForm" name="manualLocationForm" onSubmit="return onSubmitLocationManual(this)">
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
            <input type="submit" id="createLocation" value="rate"/>
        </form>
    </div>
</fieldset>