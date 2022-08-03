function setMinDate() {
    const dateToday = new Date();
    let month = dateToday.getMonth() + 1;
    let day = dateToday.getDate();
    const year = dateToday.getFullYear();

    if (month < 10)
        month = '0' + month.toString();
    if (day < 10)
        day = '0' + day.toString();

    const maxDate = year + '-' + month + '-' + day;

    document.getElementById("date-of-travel").setAttribute('min', maxDate)
}