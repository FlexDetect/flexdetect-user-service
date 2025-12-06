

# FlexDetect User Service

## Vsebina
- [Namen in funkcionalnosti](#namen-in-funkcionalnosti)
- [Avtentikacija in avtorizacija](#avtentikacija-in-avtorizacija)
- [Tehnološki sklad](#tehnološki-sklad)
- [Glavni API endpointi](#glavni-api-endpointi)
- [Varnostni ukrepi](#varnostni-ukrepi)
- [Integracija](#integracija)
- [Razvojne smernice](#razvojne-smernice)

---

## Namen in funkcionalnosti
Mikrostoritev za upravljanje uporabniških računov, vključno z:

- Registracijo in prijavo uporabnikov
- Upravljanjem profilov in pravic
- Vzdrževanjem varnosti in zasebnosti
- Izdajanje in validacijo JWT tokenov za dostop do ostalih storitev

---

## Avtentikacija in avtorizacija
- Implementacija **OAuth 2.0** in **JWT** za varno upravljanje seans
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

## Varnostni ukrepi
- Vse komunikacije potekajo prek HTTPS
- Ograjevanje poskusov prijave (rate limiting)
- Redne varnostne posodobitve in revizije kode
- Zaščita pred CSRF in XSS napadi

---

## Integracija
- Služba je glavna točka avtentikacije za vse ostale mikrostoritve
- Izmenjava podatkov o uporabnikih in dostopnih pravicah z ostalimi komponentami
- Vzpostavljena enotna prijava (SSO) za spletni vmesnik

---

## Razvojne smernice
- Testiranje z JUnit, Mockito in Spring Test
- Podpora za horizontalno skaliranje preko Kubernetes
- Spremljanje varnostnih incidentov z uporabo logov in alarmov

---

**Avtor:** Aljaž Brodar  
**Zadnja posodobitev:** 1. december 2025
