def process_user(data_loader, path: str):
    """
    Бізнес-логіка: отримує дані через сервіс (data_loader),
    обробляє ім'я користувача.
    """
    data = data_loader(path)

    name = data.get("name", "").strip()

    if not name:
        return "UNKNOWN USER"

    return name.upper()
