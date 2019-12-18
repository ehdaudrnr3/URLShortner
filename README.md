
# 은행거래내역 미처리 건수 API

### :memo: 1.API 명세서

#### :bell: 미처리 건수

##### :pushpin: 기본정보
|Method|요청 URL|출력타입|인증여부
|---|---|---|---|
|GET|호스트/api/TR/Tmfbdm00100Service/uncompleted-count|JSON|Yes|

##### :pushpin: 요청변수(Request Parameter)
|요청변수|타입|필수여부|설명
|---|---|---|---|
|dept_cd|string|Y|부서코드|

##### :pushpin: 요청(Resquest) 
```
curl http://localhost:8080/api/TR/Tmfbdm00100Service/uncompleted-count?dept_cd=200000
-H "X-Authenticate-Token: 인증토큰"
```

#### :pushpin: 응답(Response)
```json
{
    "state": "success",
    "data": {
        "COUNT": 115,
        "DEPT_NM": "관리본부",
        "DEPT_CD": "200000"
    }
}
```
<br />

#### :bell: 처리



#### :bell: 프레임
________________________

[[TIP]]
도움말이나 팁을 설명하는 블록을 작성할 수 있습니다.
[[TIP]]

