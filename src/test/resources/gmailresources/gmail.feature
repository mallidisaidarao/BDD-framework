Feature:Login

Scenario Outline:validate uid field
Given launch site
When enter uid as "<u>"
And click uid next button
Then Check uid outcome with "<uc>" Criteria
When close site
Examples:
|         u              |            uc            | 
|mallidisai123@gmail.com |          uid_valid       |
|                        |          uid_blank       |
|mallidisai125@gmail.com |          uid_invalid     |

@pwd
Scenario Outline:validate pwdfield
Given launch site
When enter uid as "mallidisai123"
And click uid next button
And enter pwd as "<p>"
And click pwd next button
Then check pwd outcome with "<pc>" Criteria
When close site
Examples:
|         p              |               pc          |
|     mallidi250         |         pwd_valid         |
|                        |         pwd_Blank         |
|     mallidisai         |         invalid           |

@sendmail
Scenario:validate mailcompose
Given launch site
When enter uid as "mallidisai123@gmail.com"
And click uid next button
And enter pwd as "mallidi250"
And click pwd next button
And click Compose and sendmail

|      to                   |         subject       |         body          |
| mallidisai123@gmail.com   |         wishes        |          hi           |
|mallidisai123@gmail.com    |         wishes        |         hi hellow     |
When close site