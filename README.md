# FlexDetect User Service

## Vsebina
- [Namen in funkcionalnosti](#namen-in-funkcionalnosti)
- [Avtentikacija in avtorizacija](#avtentikacija-in-avtorizacija)
- [Glavni API endpointi](#glavni-api-endpointi)


---

## Namen in funkcionalnosti
Mikrostoritev za upravljanje uporabniških računov, vključno z:

- Registracijo in prijavo uporabnikov
- Izdajanje in validacijo JWT tokenov za dostop do ostalih storitev

---

## Avtentikacija in avtorizacija
- Implementacija **JWT** za varno prijavo
- Šifriranje gesel z bcrypt

---

## Glavni API endpointi

| Endpoint             | Metoda | Namen                               |
|----------------------|--------|-------------------------------------|
| `/api/users/register`| POST   | Registracija novega uporabnika      |
| `/api/users/login`   | POST   | Prijava in pridobitev JWT tokena    |


---



**Avtor:** Aljaž Brodar  
**Zadnja posodobitev:** 1. december 2025
