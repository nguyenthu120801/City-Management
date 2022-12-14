USE [master]
GO
/****** Object:  Database [KhuPho]    Script Date: 8/7/2022 10:52:58 PM ******/
CREATE DATABASE [KhuPho]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'KhuPho', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.NGUYENTHU\MSSQL\DATA\KhuPho.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'KhuPho_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.NGUYENTHU\MSSQL\DATA\KhuPho_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [KhuPho] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [KhuPho].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [KhuPho] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [KhuPho] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [KhuPho] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [KhuPho] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [KhuPho] SET ARITHABORT OFF 
GO
ALTER DATABASE [KhuPho] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [KhuPho] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [KhuPho] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [KhuPho] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [KhuPho] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [KhuPho] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [KhuPho] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [KhuPho] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [KhuPho] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [KhuPho] SET  DISABLE_BROKER 
GO
ALTER DATABASE [KhuPho] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [KhuPho] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [KhuPho] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [KhuPho] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [KhuPho] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [KhuPho] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [KhuPho] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [KhuPho] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [KhuPho] SET  MULTI_USER 
GO
ALTER DATABASE [KhuPho] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [KhuPho] SET DB_CHAINING OFF 
GO
ALTER DATABASE [KhuPho] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [KhuPho] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [KhuPho] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [KhuPho] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'KhuPho', N'ON'
GO
ALTER DATABASE [KhuPho] SET QUERY_STORE = OFF
GO
USE [KhuPho]
GO
/****** Object:  Table [dbo].[HODAN]    Script Date: 8/7/2022 10:52:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HODAN](
	[maHoDan] [char](10) NOT NULL,
	[soThanhVien] [int] NULL,
	[soNha] [nvarchar](50) NULL,
	[maKhuPho] [char](10) NOT NULL,
 CONSTRAINT [PK_tblmaHoDan] PRIMARY KEY CLUSTERED 
(
	[maHoDan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHUPHO]    Script Date: 8/7/2022 10:52:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHUPHO](
	[maKhuPho] [char](10) NOT NULL,
	[tenKhuPho] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblmaKhuPho] PRIMARY KEY CLUSTERED 
(
	[maKhuPho] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NGUOI]    Script Date: 8/7/2022 10:52:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NGUOI](
	[maNguoi] [char](10) NOT NULL,
	[hoVaTen] [nvarchar](30) NOT NULL,
	[tuoi] [int] NULL,
	[namSinh] [int] NULL,
	[ngheNghiep] [nvarchar](50) NULL,
	[maHoDan] [char](10) NOT NULL,
 CONSTRAINT [PK_tblNguoi] PRIMARY KEY CLUSTERED 
(
	[maNguoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USERITEM]    Script Date: 8/7/2022 10:52:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERITEM](
	[tenTaiKhoan] [char](10) NOT NULL,
	[matKhau] [char](10) NOT NULL,
	[vaitro] [bit] NOT NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD01      ', 2, N'số 4 Trần Đại Nghĩa', N'KP01      ')
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD02      ', 1, N'số 5 Bách Khoa', N'KP02      ')
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD03      ', 0, N'số 3 Nhan Đàm', N'KP01      ')
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD04      ', 1, N'60 Hoàng Quốc Việt', N'KP03      ')
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD05      ', 0, N'abc', N'KP05      ')
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD06      ', 1, N'Woawoa', N'KP06      ')
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD09      ', 0, N'Thach That ', N'KP09      ')
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD10      ', 0, N'160 Tran bach', N'KP10      ')
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD11      ', 0, N'tutu', N'KP10      ')
INSERT [dbo].[HODAN] ([maHoDan], [soThanhVien], [soNha], [maKhuPho]) VALUES (N'HD13      ', 2, N'Pham van Dong', N'KP11      ')
GO
INSERT [dbo].[KHUPHO] ([maKhuPho], [tenKhuPho]) VALUES (N'KP01      ', N'Tran Dai Nghia')
INSERT [dbo].[KHUPHO] ([maKhuPho], [tenKhuPho]) VALUES (N'KP02      ', N'Bach Khoa')
INSERT [dbo].[KHUPHO] ([maKhuPho], [tenKhuPho]) VALUES (N'KP03      ', N'ThuCute')
INSERT [dbo].[KHUPHO] ([maKhuPho], [tenKhuPho]) VALUES (N'KP05      ', N'Hoang Mai')
INSERT [dbo].[KHUPHO] ([maKhuPho], [tenKhuPho]) VALUES (N'KP06      ', N'Cầu Diễm')
INSERT [dbo].[KHUPHO] ([maKhuPho], [tenKhuPho]) VALUES (N'KP09      ', N'Hoa Lac')
INSERT [dbo].[KHUPHO] ([maKhuPho], [tenKhuPho]) VALUES (N'KP10      ', N'Khu Nguoi Dep')
INSERT [dbo].[KHUPHO] ([maKhuPho], [tenKhuPho]) VALUES (N'KP11      ', N'Hoang Hoa Tham')
GO
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG01      ', N'Trần Văn A', 22, 2000, N'Sinh Viên', N'HD01      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG02      ', N'Trần Văn B', 23, 2001, N'Sinh Viên', N'HD02      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG03      ', N'Nguyen Thị Thu', 22, 2001, N'Sinh Viên', N'HD01      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG04      ', N'Thucute', 21, 2001, N'Sinh vien', N'HD03      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG05      ', N'Quandeptrai', 22, 2001, N'Sinhvien ', N'HD04      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG06      ', N'Thudangyeunhat', 22, 2001, N'sinh vien', N'HD06      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG07      ', N'NUNU', 19, 2001, N'quan ly', N'HD05      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG09      ', N'Thu de thuong nhat', 22, 2001, N'Sinh vien', N'HD09      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG10      ', N'nguyen Thu', 22, 2001, N'Sinh Vien', N'HD09      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG11      ', N'Nu nu', 22, 2001, N'Nhân Viên', N'HD10      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG12      ', N'abc', 22, 2001, N'abc', N'HD11      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG14      ', N'Thucute', 22, 2001, N'Sinh Vien', N'HD13      ')
INSERT [dbo].[NGUOI] ([maNguoi], [hoVaTen], [tuoi], [namSinh], [ngheNghiep], [maHoDan]) VALUES (N'NG15      ', N'Xuxu', 21, 2001, N'Sinh Vien', N'HD13      ')
GO
INSERT [dbo].[USERITEM] ([tenTaiKhoan], [matKhau], [vaitro]) VALUES (N'admin     ', N'admin     ', 1)
INSERT [dbo].[USERITEM] ([tenTaiKhoan], [matKhau], [vaitro]) VALUES (N'bachtran  ', N'123       ', 0)
GO
ALTER TABLE [dbo].[HODAN]  WITH CHECK ADD  CONSTRAINT [FK_HODAN_KHUPHO] FOREIGN KEY([maKhuPho])
REFERENCES [dbo].[KHUPHO] ([maKhuPho])
GO
ALTER TABLE [dbo].[HODAN] CHECK CONSTRAINT [FK_HODAN_KHUPHO]
GO
ALTER TABLE [dbo].[NGUOI]  WITH CHECK ADD  CONSTRAINT [FK_NGUOI_HODAN] FOREIGN KEY([maHoDan])
REFERENCES [dbo].[HODAN] ([maHoDan])
GO
ALTER TABLE [dbo].[NGUOI] CHECK CONSTRAINT [FK_NGUOI_HODAN]
GO
USE [master]
GO
ALTER DATABASE [KhuPho] SET  READ_WRITE 
GO
