package Other;

public interface IWriteToFile {
    public void Initiate(String fileName);
    public void Emit(String text);
    public void Close();
}
