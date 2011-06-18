package com.wallofshame

import domain.WallOfShameParser
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import collection.mutable.HashMap


class WallOfShameParserTest extends Spec with ShouldMatchers {

  val peopleMissTimeSheet = """* Change the reporting date
* Email, Jira, VPN Account to ZenDesk
* Richard Burtan, cc Tom, Warren
* Plan resource for the Studio Team(5 + 1 QA)
* Finish the scope in middle of Aug
* Targeting the release in Sept.



TW_UTIL_TIME_MISSING_DETAIL - by Beachball cntry
Week Ending Dt:	06/12/2011
Dept:	01
View Results


Download results in :	Excel SpreadSheet 	CSV Text File 	(11 kb)


View All	First 1-73 of 73 Last
 	Beachball Country	Missing
1	Australia	Chandra,Shitesh
2	Australia	Colls,David
3	Australia	Fraser,James Robinson
4	Australia	Hunter,Robert James
5	Australia	Prieto,Romain
6	Brazil	Gravem,Alexandre Estrázulas
7	Brazil	Leal,Cassiano Bertol
8	Canada West	Ramachandran,Ganesh R
9	Canada West	Santhanam,Vinod
10	China	Huang,Chentao
11	China	Huang,Liang
12	China	Li,Liyan
13	China	Nan,Fang
14	China	Yuan,Yingjie
15	ETG	Blackwell,Dani
16	ETG	Cronemeyer,Joshua R
17	ETG	Deysel,Carli
18	ETG	Gopalakrishnappa,Arun Kumar
19	ETG	Kadambi Sudarshan,Pavan
20	ETG	Lee,Marques Brian
21	ETG	List,Steven
22	ETG	Monahan,Joseph
23	ETG	Morehead,Clifford R
24	ETG	Padegaonkar,Ketan
25	ETG	Prince,Suzanne
26	ETG	Ranganathan,Ananthapadmanabhan
27	ETG	Singh,Janmejay
28	ETG	Sudheendra,Sachin
29	ETG	Zhu,Jiajun
30	India	Bhatia,Ankur
31	India	Dharmapurikar,Sachin Vitthalrao
32	India	Elkunchwar,Pooja Rishikesh
33	India	Gupta,Ashish
34	India	Haridas,Vivek
35	India	Madhu,Preethi
36	India	Mungel,Nikhil
37	India	Nilange,Mandar
38	India	Parekh,Sunit
39	India	Purandare,Jai A
40	India	Puri,Suchit
41	India	Reddy,Kashi Vishwanatha
42	India	Singh,Vatsala
43	India	Trilokchandani,Kaavya
44	UK	Beaton,Malcolm
45	UK	Devarajan,Balaji
46	UK	Joshi,Unmesh V
47	UK	Kumar,Amit
48	UK	Rowden,Joanna
49	UK	Thangavelu,Gobinath
50	US Central	Budhabhatti,Munjal
51	US Central	Choudhury,Diptanu Gon
52	US Central	Goldstein,Linda
53	US Central	Kozak,Christopher
54	US Central	Lin,Kenny
55	US Central	Lowe,Jená Ashley
56	US Central	Monserrate,Jamie Savio
57	US Central	Pathak,Lav
58	US Central	Puskas,Ryan A
59	US Central	Putnam,Sheree Elizabeth
60	US Central	Ranganath,Roopa
61	US Central	Rastogi,Shikhar
62	US Central	Ruger,Eric J.
63	US Central	Singh,Rajeev
64	US Central	Tanguay-Carel,Matthieu
65	US East	Anderson,Sheila
66	US East	Ellis,Montra
67	US West	Brown,Timothy P.
68	US West	Covert,Bryce
69	US West	Fisher,Nathan
70	US West	Hammer,Derek
71	US West	Mckinnon,Sharlene
72	US West	Stevenson,Christopher David
73	US West	Thomas,Jannet"""

  describe("parse the people who missed timesheet from people soft") {
    it("should handle the China office with the right case") {
      val sheet: HashMap[String, List[String]] = WallOfShameParser.peopleMissedTimeSheet(peopleMissTimeSheet)
      sheet("china")(0) should be === "Yuan,Yingjie"
    }

    it("should handle the China office with all upper case") {
      val sheet: HashMap[String, List[String]] = WallOfShameParser.peopleMissedTimeSheet(peopleMissTimeSheet)
      sheet("china")(0) should be === "Yuan,Yingjie"
    }

    it("should handle the Brazil office with right case") {
      val sheet: HashMap[String, List[String]] = WallOfShameParser.peopleMissedTimeSheet(peopleMissTimeSheet)
      sheet("brazil")(0) should be === "Leal,Cassiano Bertol"
    }

    it("should handle the US central office with right case") {
      val sheet: HashMap[String, List[String]] = WallOfShameParser.peopleMissedTimeSheet(peopleMissTimeSheet)
      sheet("uscentral")(0) should be === "Tanguay-Carel,Matthieu"
    }

  }
}