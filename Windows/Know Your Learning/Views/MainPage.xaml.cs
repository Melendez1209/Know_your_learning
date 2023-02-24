using Know_Your_Learning.ViewModels;

using Microsoft.UI.Xaml.Controls;

namespace Know_Your_Learning.Views;

public sealed partial class MainPage : Page
{
    public MainViewModel ViewModel
    {
        get;
    }

    public MainPage()
    {
        ViewModel = App.GetService<MainViewModel>();
        InitializeComponent();
    }
}
