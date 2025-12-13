

# FlexDetect User Service

## Vsebina
- [Namen in funkcionalnosti](#namen-in-funkcionalnosti)
- [Avtentikacija in avtorizacija](#avtentikacija-in-avtorizacija)
- [Tehnološki sklad](#tehnološki-sklad)
- [Glavni API endpointi](#glavni-api-endpointi)


---

## Namen in funkcionalnosti
Mikrostoritev za upravljanje uporabniških računov, vključno z:

- Registracijo in prijavo uporabnikov
- Upravljanjem profilov in pravic
- Vzdrževanjem varnosti in zasebnosti
- Izdajanje in validacijo JWT tokenov za dostop do ostalih storitev

---

## Avtentikacija in avtorizacija
- Implementacija **OAuth 2.0** in **JWT** za varno prijavo
- Podpora za več vlog (admin, uporabnik, gost)
- Mehanizmi za zaklepanje računov ob sumu zlorabe
- Šifriranje gesel z bcrypt

---

## Tehnološki sklad
- Java 17 + Spring Security
- Maven za upravljanje odvisnosti
- MySQL baza za uporabniške podatke
- Docker za enostavno namestitev in skaliranje
---

## Glavni API endpointi

| Endpoint             | Metoda | Namen                                |
|----------------------|--------|------------------------------------|
| `/auth/register`     | POST   | Registracija novega uporabnika      |
| `/auth/login`        | POST   | Prijava in pridobitev JWT tokena    |
| `/users/{id}`        | GET    | Pridobitev podatkov o uporabniku    |
| `/users/{id}`        | PUT    | Posodobitev uporabniških podatkov   |
| `/users/{id}/roles`  | POST   | Nastavitev uporabniških vlog        |

---



**Avtor:** Aljaž Brodar  
**Zadnja posodobitev:** 1. december 2025
