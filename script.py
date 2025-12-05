from data_store import DataStore
from utils import normalize_text

def process_message(text, store: DataStore):
    clean = normalize_text(text)
    store.add_record(clean)
    return f"Processed: {clean}"
