package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует сервис для управления пользователями и их банковскими счетами.
 * Предоставляет функциональность для добавления пользователей, управления их счетами,
 * а также выполнения переводов между счетами.
 *
 * @author salavatmubaraksin
 * @version 1.0
 */
public class BankService {
    /**
     * Хранилище данных о пользователях и их банковских счетах.
     * Пользователи представлены как ключи, а списки их счетов — как значения.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в систему.
     * Если пользователь уже существует, операция игнорируется.
     *
     * @param user пользователь, которого нужно добавить.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удаляет пользователя из системы по его паспорту.
     *
     * @param passport паспорт пользователя, которого нужно удалить.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, "Ivan"));
    }

    /**
     * Добавляет новый банковский счет пользователю.
     * Если пользователь не найден или счет уже существует, операция игнорируется.
     *
     * @param passport паспорт пользователя, которому нужно добавить счет.
     * @param account  банковский счет для добавления.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя по паспорту.
     *
     * @param passport паспорт пользователя для поиска.
     * @return пользователь, если найден, или {@code null}, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        User findedUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                findedUser = user;
                break;
            }
        }
        return findedUser;
    }

    /**
     * Находит банковский счет пользователя по реквизитам.
     *
     * @param passport  паспорт пользователя, которому принадлежит счет.
     * @param requisite реквизиты счета для поиска.
     * @return счет, если найден, или {@code null}, если счет не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Выполняет перевод средств между счетами.
     *
     * @param sourcePassport       паспорт отправителя.
     * @param sourceRequisite      реквизиты счета отправителя.
     * @param destinationPassport  паспорт получателя.
     * @param destinationRequisite реквизиты счета получателя.
     * @param amount               сумма перевода.
     * @return {@code true}, если перевод выполнен успешно, иначе {@code false}.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account accountToTransfer = findByRequisite(destinationPassport, destinationRequisite);
        Account accountSource = findByRequisite(sourcePassport, sourceRequisite);
        if (accountSource != null && accountToTransfer != null && accountSource.getBalance() >= amount) {
            accountToTransfer.setBalance(accountToTransfer.getBalance() + amount);
            accountSource.setBalance(accountSource.getBalance() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Возвращает список счетов пользователя.
     *
     * @param user пользователь, для которого нужно получить счета.
     * @return список счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}