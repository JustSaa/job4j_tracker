package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывающий модель для данных типа Аккаунт для банковского приложени
 *
 * @author salavatmubaraksin
 * @version 1.0
 */
public class Account {

    /**
     * Хранит реквезиты
     */
    private String requisite;
    /**
     * Хранит баланс
     */
    private double balance;

    /**
     * Конструктор для модели
     *
     * @param requisite
     * @param balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты аккаунта.
     *
     * @return строка, содержащая реквизиты аккаунта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает новые реквезиты
     *
     * @param requisite новые реквезиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращет балан
     *
     * @return текщий баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает новый баланс для аккаунта.
     *
     * @param balance Новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределяет метод equals для сравнения объектов Account.
     * Сравнение производится только по реквизитам.
     *
     * @param o объект для сравнения
     * @return true, если объекты равны; false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределяет метод hashCode для класса Account.
     * Хэш-код основывается на реквизитах.
     *
     * @return целочисленное значение хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}