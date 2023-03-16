var flag = false;
function processForm() {
    var sum = 0;
    hc = new Array(24);

    // Q1
    if (document.test_Form.q1[0].checked == 1)
        sum += 0;
    if (document.test_Form.q1[1].checked == 1)
        sum += 1;
    if (document.test_Form.q1[2].checked == 1)
        sum += 2;
    if (document.test_Form.q1[3].checked == 1)
        sum += 3;
    if (document.test_Form.q1[4].checked == 1)
        sum += 4;

    // Q2
    if (document.test_Form.q2[0].checked == 1)
        sum += 0;
    if (document.test_Form.q2[1].checked == 1)
        sum += 1;
    if (document.test_Form.q2[2].checked == 1)
        sum += 2;
    if (document.test_Form.q2[3].checked == 1)
        sum += 3;
    if (document.test_Form.q2[4].checked == 1)
        sum += 4;

    // Q3
    if (document.test_Form.q3[0].checked == 1)
        sum += 0;
    if (document.test_Form.q3[1].checked == 1)
        sum += 1;
    if (document.test_Form.q3[2].checked == 1)
        sum += 2;
    if (document.test_Form.q3[3].checked == 1)
        sum += 3;
    if (document.test_Form.q3[4].checked == 1)
        sum += 4;

    // Q4
    if (document.test_Form.q4[0].checked == 1)
        sum += 0;
    if (document.test_Form.q4[1].checked == 1)
        sum += 1;
    if (document.test_Form.q4[2].checked == 1)
        sum += 2;

    // Q5
    if (document.test_Form.q5[0].checked == 1)
        sum += 0;
    if (document.test_Form.q5[1].checked == 1)
        sum += 1;
    if (document.test_Form.q5[2].checked == 1)
        sum += 2;

    // Q6
    if (document.test_Form.q6[0].checked == 1)
        sum += 0;
    if (document.test_Form.q6[1].checked == 1)
        sum += 1;
    if (document.test_Form.q6[2].checked == 1)
        sum += 2;

    // Q7
    if (document.test_Form.q7[0].checked == 1)
        sum += 0;
    if (document.test_Form.q7[1].checked == 1)
        sum += 1;
    if (document.test_Form.q7[2].checked == 1)
        sum += 2;
    if (document.test_Form.q7[3].checked == 1)
        sum += 3;
    if (document.test_Form.q7[4].checked == 1)
        sum += 4;

    // Q8
    if (document.test_Form.q8[0].checked == 1)
        sum += 0;
    if (document.test_Form.q8[1].checked == 1)
        sum += 1;
    if (document.test_Form.q8[2].checked == 1)
        sum += 2;
    if (document.test_Form.q8[3].checked == 1)
        sum += 3;
    if (document.test_Form.q8[4].checked == 1)
        sum += 4;

    // Q9
    if (document.test_Form.q9[0].checked == 1)
        sum += 0;
    if (document.test_Form.q9[1].checked == 1)
        sum += 1;
    if (document.test_Form.q9[2].checked == 1)
        sum += 2;
    if (document.test_Form.q9[3].checked == 1)
        sum += 3;
    if (document.test_Form.q9[4].checked == 1)
        sum += 4;

    // Q10
    if (document.test_Form.q10[0].checked == 1)
        sum += 0;
    if (document.test_Form.q10[1].checked == 1)
        sum += 1;
    if (document.test_Form.q10[2].checked == 1)
        sum += 2;
    if (document.test_Form.q10[3].checked == 1)
        sum += 3;
    if (document.test_Form.q10[4].checked == 1)
        sum += 4;

    // Q11
    if (document.test_Form.q11[1].checked == 1)
        sum += 0;
    if (document.test_Form.q11[2].checked == 1)
        sum += 1;
    if (document.test_Form.q11[3].checked == 1)
        sum += 2;
    if (document.test_Form.q11[4].checked == 1)
        sum += 3;
    if (document.test_Form.q11[5].checked == 1)
        sum += 4;

    // Q12
    if (document.test_Form.q12[1].checked == 1)
        sum += 0;
    if (document.test_Form.q12[2].checked == 1)
        sum += 1;
    if (document.test_Form.q12[3].checked == 1)
        sum += 2;

    // Q13
    if (document.test_Form.q13[1].checked == 1)
        sum += 0;
    if (document.test_Form.q13[2].checked == 1)
        sum += 1;
    if (document.test_Form.q13[3].checked == 1)
        sum += 2;

    // Q14
    if (document.test_Form.q14[1].checked == 1)
        sum += 0;
    if (document.test_Form.q14[2].checked == 1)
        sum += 1;
    if (document.test_Form.q14[3].checked == 1)
        sum += 2;

    // Q15
    if (document.test_Form.q15[1].checked == 1)
        sum += 0;
    if (document.test_Form.q15[2].checked == 1)
        sum += 1;
    if (document.test_Form.q15[3].checked == 1)
        sum += 2;
    if (document.test_Form.q15[4].checked == 1)
        sum += 3;
    if (document.test_Form.q15[5].checked == 1)
        sum += 4;

    // Q16
    if (document.test_Form.q16[0].checked == 1)
        sum += 0;
    if (document.test_Form.q16[1].checked == 1)
        sum += 1;
    if (document.test_Form.q16[2].checked == 1)
        sum += 2;

    // Q17
    if (document.test_Form.q17[0].checked == 1)
        sum += 0;
    if (document.test_Form.q17[1].checked == 1)
        sum += 1;
    if (document.test_Form.q17[2].checked == 1)
        sum += 2;

    // Q18
    if (document.test_Form.q18[0].checked == 1)
        sum += 0;
    if (document.test_Form.q18[1].checked == 1)
        sum += 1;
    if (document.test_Form.q18[2].checked == 1)
        sum += 2;

    // Q19
    if (document.test_Form.q19[0].checked == 1)
        sum += 0;
    if (document.test_Form.q19[1].checked == 1)
        sum += 1;
    if (document.test_Form.q19[2].checked == 1)
        sum += 2;
    if (document.test_Form.q19[3].checked == 1)
        sum += 3;
    if (document.test_Form.q19[4].checked == 1)
        sum += 4;

    // Q20
    if (document.test_Form.q20[0].checked == 1)
        sum += 0;
    if (document.test_Form.q20[1].checked == 1)
        sum += 1;
    if (document.test_Form.q20[2].checked == 1)
        sum += 2;
    if (document.test_Form.q20[3].checked == 1)
        sum += 3;
    if (document.test_Form.q20[4].checked == 1)
        sum += 4;

    // Q21
    if (document.test_Form.q21[1].checked == 1)
        sum += 0;
    if (document.test_Form.q21[2].checked == 1)
        sum += 1;
    if (document.test_Form.q21[3].checked == 1)
        sum += 2;

    // Q22
    if (document.test_Form.q22[1].checked == 1)
        sum += 0;
    if (document.test_Form.q22[2].checked == 1)
        sum += 1;
    if (document.test_Form.q22[3].checked == 1)
        sum += 2;
    if (document.test_Form.q22[4].checked == 1)
        sum += 3;
    if (document.test_Form.q22[5].checked == 1)
        sum += 4;

    // Q23
    if (document.test_Form.q23[1].checked == 1)
        sum += 0;
    if (document.test_Form.q23[2].checked == 1)
        sum += 1;
    if (document.test_Form.q23[3].checked == 1)
        sum += 2;
    if (document.test_Form.q23[4].checked == 1)
        sum += 3;
    if (document.test_Form.q23[5].checked == 1)
        sum += 4;

    // Q24
    if (document.test_Form.q24[1].checked == 1)
        sum += 0;
    if (document.test_Form.q24[2].checked == 1)
        sum += 1;
    if (document.test_Form.q24[3].checked == 1)
        sum += 2;
    if (document.test_Form.q24[4].checked == 1)
        sum += 3;
    if (document.test_Form.q24[5].checked == 1)
        sum += 4;


    // Result
    if (sum < 8)
        document.test_Form.answer.value = "Your total score is " + sum + " points\n Normal";
    if (sum < 20 && sum >= 8)
        document.test_Form.answer.value = "Your total score is " + sum + " points\n Possible depression";
    if (sum < 35 && sum >= 20)
        document.test_Form.answer.value = "Your total score is " + sum + " points\n Must have depression";
    if (sum >= 35)
        document.test_Form.answer.value = "Your total score is " + sum + " points\n Major Depressive Disorder";

    flag = true;
}


window.onload = function () {
    countDown();
    var time = 720;

    function addZero(i) {
        return i < 10 ? "0" + i: i + "";
    }

    function countDown(){
        var m = parseInt(time / 60 % 60);
        var s = parseInt(time % 60);
        m = addZero(m);
        s = addZero(s)
        
	    document.querySelector(".count").innerHTML = `time: ${m} : ${s}`;
    
        if (time <= 0 || flag == true) {
            document.querySelector(".count").innerHTML = "活动已结束";
            processForm();
            return;
        }
        time--;
        setTimeout(countDown, 1000);
    }
}
